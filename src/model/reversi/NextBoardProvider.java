
package model.reversi;

import java.util.HashMap;

public class NextBoardProvider {
    public static HashMap<Position, Board> getPossibleCases(final Board currentBoard, final Disk disk) {
        final HashMap<Position, Board> possibleCases = new HashMap<Position, Board>();

        for (Integer y = Board.A1.y(); y <= Board.H8.y(); y++) {
            for (Integer x = Board.A1.x(); x <= Board.H8.x(); x++) {
                final Position pos = new Position(y, x);
                final Board nextBoard = currentBoard.clone();

                if (nextBoard.put(disk, pos) != 0) {
                    possibleCases.put(pos, nextBoard);
                }
            }
        }
        return possibleCases;
    }
}