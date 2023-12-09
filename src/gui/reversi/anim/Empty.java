
package gui.reversi.anim;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Empty implements ICellAnim {

    public Empty() {
    }

    public Path getImagePath() {
        return Paths.get("res/empty_cell.png");
    }

}