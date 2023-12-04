
package view.reversi.anim;

import java.awt.Image;
import java.awt.Toolkit;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Black implements ICellAnim {
    long timer = 0;

    public Black() {
        this.timer = System.currentTimeMillis();
    }

    public Image anim() {
        Path path = Paths.get("res/black_cell.png");
        return Toolkit.getDefaultToolkit().getImage(path.toString());
    }

}