
package gui.reversi.anim;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FlipFromBlackToWhite implements ICellAnim {
    int frame = 0;

    public FlipFromBlackToWhite() {
        this.frame = 0;
    }

    public Path getImagePath() {

        Path path;
        switch (this.frame++) {
            case 0:
                path = Paths.get("res/black_cell_3.png");
                break;
            case 1:
                path = Paths.get("res/black_cell_2.png");
                break;
            case 2:
                path = Paths.get("res/black_cell_1.png");
                break;
            case 3:
                path = Paths.get("res/empty_cell.png");
                break;
            case 4:
                path = Paths.get("res/white_cell_1.png");
                break;
            case 5:
                path = Paths.get("res/white_cell_2.png");
                break;
            case 6:
                path = Paths.get("res/white_cell_3.png");
                break;
            default:
                path = Paths.get("res/white_cell.png");
                break;
        }

        return path;
    }

}