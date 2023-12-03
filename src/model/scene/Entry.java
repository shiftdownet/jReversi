
package model.scene;

public class Entry implements model.IScene {

    public void entry() {
        view.ViewManager.getInstance().createWindow();
    }
    public void main() {

    }
    public void exit() {

    }
    public model.IScene next() {
        return new Reversi();
    }
}