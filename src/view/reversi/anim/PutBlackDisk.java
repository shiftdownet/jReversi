
package view.reversi.anim;

import java.awt.Image;
import java.awt.Toolkit;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PutBlackDisk implements ICellAnim {
    long timer = 0;

    public PutBlackDisk() {
        this.timer = System.currentTimeMillis();
    }

    public Image anim() {
        long elapsed = System.currentTimeMillis() - this.timer;

        Path path;
        switch ( (int)(elapsed / view.Config.fps) ) {
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

        return Toolkit.getDefaultToolkit().getImage(path.toString());

    }
}