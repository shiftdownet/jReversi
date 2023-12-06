
package view.reversi.anim;

import java.awt.Image;
import java.awt.Toolkit;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PutWhiteDisk implements ICellAnim {
    int frame = 0;

    public PutWhiteDisk() {
        this.frame = 0;
    }

    public Image anim() {
        Path path;
        switch ( this.frame++ ) {
            case 0:
                path = Paths.get("res/white_cell_1.png");
                break;
            case 1:
                path = Paths.get("res/white_cell_2.png");
                break;
            case 2:
                path = Paths.get("res/white_cell_3.png");
                break;
            default:
                path = Paths.get("res/white_cell.png");
                break;
        }

        return Toolkit.getDefaultToolkit().getImage(path.toString());
    }
}