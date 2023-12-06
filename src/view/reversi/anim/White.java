
package view.reversi.anim;

import java.awt.Image;
import java.awt.Toolkit;
import java.nio.file.Path;
import java.nio.file.Paths;

public class White implements ICellAnim {

    public White() {
    }

    public Image anim() {
        Path path = Paths.get("res/white_cell.png");
        return Toolkit.getDefaultToolkit().getImage(path.toString());
    }

}