
package gui.reversi;

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import gui.reversi.anim.Black;
import gui.reversi.anim.Empty;
import gui.reversi.anim.FlipFromBlackToWhite;
import gui.reversi.anim.FlipFromWhiteToBlack;
import gui.reversi.anim.ICellAnim;
import gui.reversi.anim.PutBlackDisk;
import gui.reversi.anim.PutWhiteDisk;
import gui.reversi.anim.White;
import model.reversi.Cell;
import model.reversi.Disk;

public class CellButton extends JButton implements ActionListener {
    private Cell cell;
    private Disk prevDisk;
    private ICellAnim cellAnim;
    private boolean isClicked = false;

    public static final Integer SIZE_X = 72;
    public static final Integer SIZE_Y = 72;

    public CellButton(final Cell cell) {
        this.cell = cell;
        this.prevDisk = this.cell.disk();
        this.setBorderPainted(false);
        this.setMargin(new Insets(0, 0, 0, 0));
        this.addActionListener(this);

        switch (this.cell.disk()) {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // JOptionPane.showMessageDialog(null, this.cell.pos().x().toString() + "" +
        // this.cell.pos().y().toString());
        isClicked = true;
    }

    public boolean isClicked() {
        boolean isClicked = this.isClicked;
        this.isClicked = false;
        return isClicked;
    }

    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        if ((this.prevDisk == Disk.empty) && (this.cell.disk() == Disk.white)) {
            this.cellAnim = new PutWhiteDisk();
        } else if ((this.prevDisk == Disk.empty) && (this.cell.disk() == Disk.black)) {
            this.cellAnim = new PutBlackDisk();
        } else if ((this.prevDisk == Disk.black) && (this.cell.disk() == Disk.white)) {
            this.cellAnim = new FlipFromBlackToWhite();
        } else if ((this.prevDisk == Disk.white) && (this.cell.disk() == Disk.black)) {
            this.cellAnim = new FlipFromWhiteToBlack();
        }
        this.prevDisk = this.cell.disk();
        this.setIcon(new ImageIcon(this.cellAnim.getImagePath().toString()));
    }
}