
package view.reversi;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import model.reversi.Cell;
import model.reversi.Disk;
import view.reversi.anim.*;

public class CellImage {
    private Cell cell;
    private Disk prevDisk;
    private ICellAnim cellAnim;
    private Rectangle rect;

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
    
    public Image image() {
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

    public void setBounds(final Rectangle rect) {
        this.rect = rect;
    }
    
    public Rectangle getBounds() {
        return this.rect;
    }

    public void draw(Graphics g, ImageObserver o){
        g.drawImage(this.image(), this.rect.x, this.rect.y, this.rect.width, this.rect.height, o);
    }
}