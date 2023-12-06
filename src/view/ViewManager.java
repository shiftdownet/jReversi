
package view;


public class ViewManager {
    private static ViewManager singletonViewManager = new ViewManager();
    public Window window;

    static final public int INDEX_BOARD_PANE = 0;
    static final public int INDEX_INFO_PANE = 1;

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