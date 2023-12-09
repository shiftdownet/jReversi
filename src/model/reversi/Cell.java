
package model.reversi;

public class Cell implements Cloneable {
    private Disk disk = Disk.empty;
    private Position pos = null;

    public Cell(final Position pos) {
        this.pos = pos;
    }

    public Position pos() {
        return this.pos;
    }

    public void put(Disk disk) {
        this.disk = disk;
    }

    public void flip() {
        this.disk = this.disk.back();
    }

    public boolean is(final Disk disk) {
        return (this.disk == disk);
    }

    public boolean isBackOf(final Disk disk) {
        return (this.disk.back() == disk);
    }

    public boolean isEmpty() {
        return (this.disk == Disk.empty);
    }

    public Disk disk() {
        return this.disk;
    }

    @Override
    public Cell clone() {
        Cell clonedCell = null;
        try {
            clonedCell = (Cell) super.clone();
            clonedCell.disk = this.disk;
            clonedCell.pos = this.pos;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clonedCell;
    }
}