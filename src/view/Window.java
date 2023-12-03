
package view;

import javax.swing.JFrame;

public class Window extends JFrame {
    public Window() {
        super("title");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1080,800);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}