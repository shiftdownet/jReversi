
package model.reversi;

import java.util.HashMap;

public class Agent {
    private Disk disk;
    private Board board;

    public Agent(final Disk disk) {
        this.disk = disk;
    }

    public Disk disk() {
        return this.disk;
    }

    public boolean decided() {
        return true;
    }

    public void grasp( final Board board ) {
        this.board = board;
    }

    public Position move() {
        final HashMap<Position, Board> possibleCases = NextBoardProvider.getPossibleCases(this.board, this.disk);

        if (possibleCases.size() == 0)
            return null;

        int next = (new java.util.Random()).nextInt(possibleCases.size());

        Position at = null;
        for ( Position position : possibleCases.keySet() ) {
            if ( next-- == 0 ) {
                at = position;
                break;
            }
        }
        return at;
    }
}