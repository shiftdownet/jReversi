
package model.reversi;

import java.util.ArrayList;

public class Board implements Cloneable {
    private Cell[][] cells;
    private ArrayList<Position> positions;

    public static final Integer SENTINEL = 1;
    public static final Integer SIZE = 8 + (SENTINEL * 2);

    public static final Position FIRST = new Position(0, 0);
    public static final Position LAST = new Position(SIZE, SIZE);
    public static final Position A1 = new Position(0 + SENTINEL, 0 + SENTINEL);
    public static final Position D4 = new Position(3 + SENTINEL, 3 + SENTINEL);
    public static final Position D5 = new Position(4 + SENTINEL, 3 + SENTINEL);
    public static final Position E4 = new Position(3 + SENTINEL, 4 + SENTINEL);
    public static final Position E5 = new Position(4 + SENTINEL, 4 + SENTINEL);
    public static final Position H8 = new Position(7 + SENTINEL, 7 + SENTINEL);

    public Board() {
        this.cells = new Cell[Board.SIZE][Board.SIZE];
        for (Integer y = Board.FIRST.y(); y < Board.LAST.y(); y++) {
            for (Integer x = Board.FIRST.x(); x < Board.LAST.x(); x++) {
                this.cells[y][x] = new Cell(new Position(y, x));
            }
        }

        positions = new ArrayList<Position>();
        for (Integer y = Board.A1.y(); y <= Board.H8.y(); y++) {
            for (Integer x = Board.A1.x(); x <= Board.H8.x(); x++) {
                positions.add(new Position(y, x));
            }
        }
    }

    public ArrayList<Position> positions() {
        return this.positions;
    }

    public Cell at(final Position pos) {
        return this.cells[pos.y()][pos.x()];
    }

    public Integer put(final Disk mineDisk, final Position at) {
        Integer totalNumberOfDisksToFlip = 0;
        // There is no disk yet.
        if (this.at(at).isEmpty()) {
            // Search each direction.
            for (Integer dy = -1; dy <= 1; dy++) {
                for (Integer dx = -1; dx <= 1; dx++) {
                    final Position direction = new Position(dy, dx);
                    if ((direction.y() != 0) || (direction.x() != 0)) {
                        Position offsetPos = at;

                        // Count number of back side disk its direction.
                        Integer numberOfBackSideDisks = 0;
                        for (offsetPos = offsetPos.add(direction); this.at(offsetPos)
                                .isBackOf(mineDisk); offsetPos = offsetPos.add(direction)) {
                            numberOfBackSideDisks++;
                        }
                        // It exists at least one.
                        if (0 < numberOfBackSideDisks) {
                            // Finally, there is the same as your owns.
                            if (this.at(offsetPos).is(mineDisk)) {
                                // Actually flip.
                                for (offsetPos = offsetPos.sub(direction); this.at(offsetPos)
                                        .isBackOf(mineDisk); offsetPos = offsetPos.sub(direction)) {
                                    this.at(offsetPos).flip();
                                }
                                totalNumberOfDisksToFlip += numberOfBackSideDisks;
                            }
                        }
                    }
                }
            }
            if (0 < totalNumberOfDisksToFlip) {
                this.at(at).put(mineDisk);
            }
        }
        return totalNumberOfDisksToFlip;
    }

    public Integer count(final Disk disk) {
        Integer numberOfDisk = 0;

        for (Position pos : this.positions()) {
            if (this.at(pos).is(disk)) {
                numberOfDisk++;
            }
        }
        return numberOfDisk;
    }

    @Override
    public Board clone() {
        Board clonedBoard = null;
        try {
            clonedBoard = (Board) super.clone();
            clonedBoard.cells = new Cell[Board.SIZE][Board.SIZE];
            for (Integer y = Board.FIRST.y(); y < Board.LAST.y(); y++) {
                for (Integer x = Board.FIRST.x(); x < Board.LAST.x(); x++) {
                    clonedBoard.cells[y][x] = this.cells[y][x].clone();
                }
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clonedBoard;
    }
}