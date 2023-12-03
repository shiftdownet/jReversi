
package controller;


import model.IScene;
import model.scene.*;

public class GameController {
    public GameController() {

    }

    public void main() {
        IScene scene = new Entry();

        System.out.println("Enter to " + scene);
        scene.entry();

        while( !(scene instanceof Exit) ) {
            scene.main();

            IScene next = scene.next();
            if ( next != null ) {
                System.out.println("Exit from " + scene);
                scene.exit();
                scene = next;
                System.out.println("Enter to " + scene);
                scene.entry();
            }

            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }
        }
    }
}