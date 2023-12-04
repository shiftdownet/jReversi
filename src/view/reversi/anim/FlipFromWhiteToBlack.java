
package view.reversi.anim;

import java.awt.Image;
import java.awt.Toolkit;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FlipFromWhiteToBlack implements ICellAnim {
    long timer = 0;

    public FlipFromWhiteToBlack() {
        this.timer = System.currentTimeMillis();
    }

    public Image anim() {
        long elapsed = System.currentTimeMillis() - this.timer;

        Path path;
        switch ( (int)(elapsed / view.Config.fps) ) {
            case 0:
                path = Paths.get("res/white_cell_3.png");
                break;
            case 1:
                path = Paths.get("res/white_cell_2.png");
                break;
            case 2:
                path = Paths.get("res/white_cell_1.png");
                break;
            case 3:
                path = Paths.get("res/empty_cell.png");
                break;
            case 4:
                path = Paths.get("res/black_cell_1.png");
                break;
            case 5:
                path = Paths.get("res/black_cell_2.png");
                break;
            case 6:
                path = Paths.get("res/black_cell_3.png");
                break;
            default:
                path = Paths.get("res/black_cell.png");
                break;
        }

        return Toolkit.getDefaultToolkit().getImage(path.toString());
    }

}