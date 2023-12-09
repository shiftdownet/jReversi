
package gui.reversi.anim;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Black implements ICellAnim {

    public Black() {
    }

    public Path getImagePath() {
        return Paths.get("res/black_cell.png");
    }
}