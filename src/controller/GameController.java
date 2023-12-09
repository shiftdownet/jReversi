
package controller;

import model.IScene;
import model.scene.Entry;
import model.scene.Exit;

public class GameController {
    public GameController() {

    }

    public void main() {
        IScene scene = new Entry();

        System.out.println("Enter to " + scene);
        scene.entry();

        PeriodicityGenerator pGenerator = new PeriodicityGenerator();

        while (!(scene instanceof Exit)) {
            if (pGenerator.elapsed()) {
                scene.main();

                IScene next = scene.next();
                if (next != null) {
                    System.out.println("Exit from " + scene);
                    scene.exit();
                    scene = next;
                    System.out.println("Enter to " + scene);
                    scene.entry();
                }
            }
        }
    }
}