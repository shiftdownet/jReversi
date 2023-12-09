
package gui.reversi.anim;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PutBlackDisk implements ICellAnim {
    int frame = 0;

    public PutBlackDisk() {
        this.frame = 0;
    }

    public Path getImagePath() {
        Path path;
        switch (this.frame++) {
            case 0:
                path = Paths.get("res/black_cell_1.png");
                break;
            case 1:
                path = Paths.get("res/black_cell_2.png");
                break;
            case 2:
                path = Paths.get("res/black_cell_3.png");
                break;
            default:
                path = Paths.get("res/black_cell.png");
                break;
        }

        return path;
    }
}