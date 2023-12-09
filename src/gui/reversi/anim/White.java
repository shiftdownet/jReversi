
package gui.reversi.anim;

import java.nio.file.Path;
import java.nio.file.Paths;

public class White implements ICellAnim {

    public White() {
    }

    public Path getImagePath() {
        return Paths.get("res/white_cell.png");
    }

}