
package view.reversi;

import java.awt.Image;

import model.reversi.Cell;
import model.reversi.Disk;
import view.reversi.anim.*;

public class CellImage {
    private Cell cell;
    private Disk prevDisk;
    private ICellAnim cellAnim;

    public static final Integer SIZE_X = 72;
    public static final Integer SIZE_Y = 72;

    public CellImage(final Cell cell) {
        this.cell = cell;
        this.prevDisk = this.cell.disk();

        switch( this.cell.disk() ) {
            case black:
                this.cellAnim = new Black();
                break;
            case white:
                this.cellAnim = new White();
                break;
            default:
                this.cellAnim = new Empty();
                break;
        }
    }
    
    public Image object() {
        if ( ( this.prevDisk == Disk.empty ) && ( this.cell.disk() == Disk.white ) ) {
            this.cellAnim = new PutWhiteDisk();
        }
        else if ( ( this.prevDisk == Disk.empty ) && ( this.cell.disk() == Disk.black ) ) {
            this.cellAnim = new PutBlackDisk();
        }
        else if ( ( this.prevDisk == Disk.black ) && ( this.cell.disk() == Disk.white ) ) {
            this.cellAnim = new FlipFromBlackToWhite();
        }
        else if ( ( this.prevDisk == Disk.white ) && ( this.cell.disk() == Disk.black ) ) {
            this.cellAnim = new FlipFromWhiteToBlack();
        }
        this.prevDisk = this.cell.disk();

        return this.cellAnim.anim();
    }
}