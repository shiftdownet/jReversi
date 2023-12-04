
package model.scene;

import model.reversi.Agent;
import model.reversi.Board;
import model.reversi.Disk;
import model.reversi.Referee;
import view.reversi.BoardPanel;
import view.reversi.CellImage;
import view.reversi.InfoPanel;

import java.awt.Color;

import model.IScene;

public class Reversi implements model.IScene {
    private Board board;
    private Referee referee;
    private BoardPanel boardPanel;
    private InfoPanel infoPanel;
    private IScene next = null;
    private long timer = 0;

    public void entry() {
        board = new Board();
        referee = new Referee();
        Agent agent1 = new Agent(Disk.black);
        Agent agent2 = new Agent(Disk.white);

        referee.prepareBoard(board);
        referee.accept(agent1, agent2);

        referee.startGame();

        boardPanel = new view.reversi.BoardPanel(board);
        boardPanel.setBackground(Color.GREEN);
        boardPanel.setBounds(0,0,CellImage.SIZE_X * Board.LAST.x(),800);

        infoPanel = new view.reversi.InfoPanel(board);
        infoPanel.setBackground(Color.GRAY);
        infoPanel.setBounds(CellImage.SIZE_X * Board.LAST.x(),0,360,800);
        
        view.ViewManager.getInstance().window.add(boardPanel);
        view.ViewManager.getInstance().window.add(infoPanel);
        view.ViewManager.getInstance().window.setVisible(true);
    }

    public void main() {
        if ( this.timer != 0 ) {
            if ( ( System.currentTimeMillis() - this.timer ) > view.Config.fps * 10 ) {
                this.next = new Exit();
            }
        }else{
            if ( !referee.conductGame() ) {
                this.timer = System.currentTimeMillis();
            }
        }

        boardPanel.repaint();
        infoPanel.repaint();
    }

    public void exit() {

    }

    public model.IScene next() {
        return this.next;
    }
}