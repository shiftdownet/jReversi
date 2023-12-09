
package model.reversi;

import java.util.HashMap;

public class NextBoardProvider {
    public static HashMap<Position, Board> getPossibleCases(final Board currentBoard, final Disk disk) {
        final HashMap<Position, Board> possibleCases = new HashMap<Position, Board>();

        for (Position pos : currentBoard.positions()) {
            final Board nextBoard = currentBoard.clone();

            if (nextBoard.put(disk, pos) != 0) {
                possibleCases.put(pos, nextBoard);
            }
        }

        return possibleCases;
    }
}