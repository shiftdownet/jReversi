
package controller;

import java.util.HashMap;

import model.reversi.Agent;
import model.reversi.Board;
import model.reversi.Disk;
import model.reversi.NextBoardProvider;
import model.reversi.Position;
import model.scene.Reversi;

public class Player extends Agent {
    private Position at;

    public Player(final Disk disk) {
        super(disk);
    }

    public boolean decided() {
        final HashMap<Position, Board> possibleCases = NextBoardProvider.getPossibleCases(this.board, this.disk);

        if (possibleCases.size() == 0) {
            return true;
        }

        for (Position pos : board.positions()) {
            if (Reversi.boardPanel().at(pos).isClicked()) {
                this.at = pos;
                return true;
            }
        }

        return false;
    }

    public Position move() {
        final Position ret = this.at;
        this.at = null;
        return ret;
    }
}