
package gui;

public class GuiManager {
    private static GuiManager singletonGuiManager = new GuiManager();
    public Window window;

    static final public int INDEX_BOARD_PANE = 0;
    static final public int INDEX_INFO_PANE = 1;

    private GuiManager() {
    }

    public void createWindow() {
        window = new Window();
        window.setVisible(true);
        window.setLayout(null);
    }

    public static GuiManager getInstance() {
        return singletonGuiManager;
    }
}