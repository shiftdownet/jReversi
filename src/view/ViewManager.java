
package view;


public class ViewManager {
    private static ViewManager singletonViewManager = new ViewManager();
    public Window window;

    private ViewManager(){
    }

    public void createWindow() {
        window = new Window();
        window.setVisible(true);
        window.setLayout(null);
    }

    public static ViewManager getInstance(){
        return singletonViewManager;
    }
}