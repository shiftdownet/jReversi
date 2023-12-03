
package view.reversi;

import java.awt.Image;
import java.awt.Toolkit;
import java.nio.file.Path;
import java.nio.file.Paths;

import model.reversi.Cell;

public class CellImage {
    private Cell cell;

    public static final Integer SIZE_X = 72;
    public static final Integer SIZE_Y = 72;

    public CellImage(final Cell cell) {
        this.cell = cell;
    }
    
    public Image object() {
        Path path;

        switch (this.cell.disk()) {
            case black:
                path = Paths.get("res/black_cell.png");
                break;
            case white:
                path = Paths.get("res/white_cell.png");
                break;
            case empty:
                path = Paths.get("res/empty_cell.png");
                break;
            default:
                return null;
        }

        return Toolkit.getDefaultToolkit().getImage(path.toString());
    }
}