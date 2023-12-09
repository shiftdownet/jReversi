
package model.reversi;

import java.util.HashMap;

public class Agent {
    protected Disk disk;
    protected Board board;
    protected Integer counter = 1;

    public Agent(final Disk disk) {
        this.disk = disk;
    }

    public Disk disk() {
        return this.disk;
    }

    public boolean decided() {
        return (counter++ % 20) == 0;
    }

    public void grasp(final Board board) {
        this.board = board;
    }

    public Position move() {
        final HashMap<Position, Board> possibleCases = NextBoardProvider.getPossibleCases(this.board, this.disk);

        if (possibleCases.size() == 0)
            return null;

        int next = (new java.util.Random()).nextInt(possibleCases.size());

        Position at = null;
        for (Position position : possibleCases.keySet()) {
            if (next-- == 0) {
                at = position;
                break;
            }
        }
        return at;
    }
}