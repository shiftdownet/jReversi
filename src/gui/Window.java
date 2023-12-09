
package gui;

import javax.swing.JFrame;

public class Window extends JFrame {
    public Window() {
        super("jReversi");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1080, 800);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}