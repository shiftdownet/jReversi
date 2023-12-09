
package gui.reversi;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import model.reversi.Board;
import model.reversi.Position;

public class BoardPanel extends JPanel {
    private CellButton[][] cells;
    private Board board;

    public BoardPanel(final Board board) {
        this.board = board;
        this.setLayout(null);
        Rectangle rect = this.getBounds();

        this.cells = new CellButton[Board.SIZE][Board.SIZE];
        for (Position pos : board.positions()) {
            this.cells[pos.y()][pos.x()] = new CellButton(board.at(pos));
        }

        for (Position pos : board.positions()) {
            this.at(pos).setBounds(new Rectangle(
                    pos.x() * CellButton.SIZE_X + rect.x,
                    pos.y() * CellButton.SIZE_Y + rect.y,
                    CellButton.SIZE_X,
                    CellButton.SIZE_Y));
            this.add(this.at(pos));
        }
    }

    public CellButton at(final Position pos) {
        return this.cells[pos.y()][pos.x()];
    }

    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);

        for (Position pos : this.board.positions()) {
            this.at(pos).repaint();
        }
    }
}
