
package model.reversi;

public enum Disk {
    empty, black, white;

    public Disk back() {
        switch (this) {
            case black:
                return Disk.white;
            case white:
                return Disk.black;
            default:
                return Disk.empty;
        }
    }
}