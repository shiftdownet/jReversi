
package controller;

import java.awt.Rectangle;
import java.util.HashMap;
import model.reversi.*;
import view.reversi.BoardPanel;

import java.awt.event.*;

public class Player extends Agent implements MouseListener {
    private Position at;
    private BoardPanel boardPanel;

    public Player(final Disk disk) {
        super(disk);
    }

    public void setBoardPanel( final BoardPanel boardPanel ) {
        this.boardPanel = boardPanel;
    }

    public void mouseClicked(MouseEvent e) {
        Position clicked = new Position(e.getY(), e.getX());
        System.out.println(clicked);
        for (Integer y = Board.A1.y(); y <= Board.H8.y(); y++) {
            for (Integer x = Board.A1.x(); x <= Board.H8.x(); x++) {
                final Position pos = new Position(y, x);
                Rectangle rect = this.boardPanel.getCellBoundsAt(pos);
                if ((rect.x <= clicked.x()) && (clicked.x() <= rect.x + rect.width) &&
                        (rect.y <= clicked.y()) && (clicked.y() <= rect.y + rect.height)) {
                    this.at = pos;
                }
            }
        }

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public boolean decided() {
        final HashMap<Position, Board> possibleCases = NextBoardProvider.getPossibleCases(this.board, this.disk);

        if (possibleCases.size() == 0) {
            return true;
        }

        if (this.at != null) {
            return true;
        }

        return false;
    }

    public Position move() {
        final Position ret = this.at;
        this.at = null;
        return ret;
    }
}