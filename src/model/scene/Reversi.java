
package model.scene;

import model.reversi.Agent;
import model.reversi.Board;
import model.reversi.Disk;
import model.reversi.Referee;
import gui.reversi.BoardPanel;
import gui.reversi.InfoPanel;

import java.awt.Color;

import controller.Player;
import model.IScene;

public class Reversi implements model.IScene {
    private Board board;
    private Referee referee;
    static private BoardPanel boardPanel;
    static private InfoPanel infoPanel;
    private IScene next = null;
    private long counter = 0;

    public void entry() {
        board = new Board();
        referee = new Referee();
        Agent agent1 = new Player(Disk.black);
        Agent agent2 = new Agent(Disk.white);

        referee.prepareBoard(board);
        referee.accept(agent1, agent2);

        referee.startGame();

        boardPanel = new gui.reversi.BoardPanel(board);
        boardPanel.setBackground(Color.GRAY);
        boardPanel.setBounds(0, 0, 720, 800);

        infoPanel = new gui.reversi.InfoPanel(board);
        infoPanel.setBackground(Color.darkGray);
        infoPanel.setBounds(720, 0, 360, 800);

        gui.GuiManager.getInstance().window.add(boardPanel, gui.GuiManager.INDEX_BOARD_PANE);
        gui.GuiManager.getInstance().window.add(infoPanel, gui.GuiManager.INDEX_INFO_PANE);
        gui.GuiManager.getInstance().window.setVisible(true);
    }

    public void main() {
        if (!referee.conductGame()) {
            counter++;
            if (counter > 10) {
                next = new Exit();
            }
        }

        boardPanel.repaint();
        infoPanel.repaint();
    }

    public void exit() {

    }

    public model.IScene next() {
        return next;
    }

    static public BoardPanel boardPanel() {
        return boardPanel;
    }
}