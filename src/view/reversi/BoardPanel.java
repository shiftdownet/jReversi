
package view.reversi;

import java.awt.Graphics;

import javax.swing.JPanel;

import model.reversi.Board;
import model.reversi.Position;

public class BoardPanel extends JPanel {
    private CellImage[][] cells;

    public BoardPanel(final Board board) {
        this.cells = new CellImage[Board.SIZE][Board.SIZE];
        for (Integer y = Board.FIRST.y(); y < Board.LAST.y(); y++) {
            for (Integer x = Board.FIRST.x(); x < Board.LAST.x(); x++) {
                this.cells[y][x] = new CellImage( board.at(new Position(y,x)) );
            }
        }
    }

    @Override
    public void paintComponent(final Graphics g){
        super.paintComponent(g);

        for (Integer y = Board.A1.y(); y <= Board.H8.y(); y++) {
            for (Integer x = Board.A1.x(); x <= Board.H8.x(); x++) {
                final Integer posX = x * CellImage.SIZE_X;
                final Integer posY = y * CellImage.SIZE_Y;
                g.drawImage(this.cells[y][x].object(), posX, posY, CellImage.SIZE_X, CellImage.SIZE_Y, this);
            }
        }

    }
}
