
package gui.reversi;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.reversi.Board;
import model.reversi.Disk;

public class InfoPanel extends JPanel {
    private Board board;

    private JLabel blackCount;
    private JLabel whiteCount;

    public InfoPanel(final Board board) {
        this.board = board;
        this.setLayout(null);

        this.blackCount = new JLabel("");
        this.blackCount.setBounds(10, 0, 360 - 10, 100);
        this.blackCount.setFont(new Font("Arial", Font.BOLD, 32));
        this.blackCount.setForeground(Color.WHITE);
        this.add(this.blackCount);
        this.whiteCount = new JLabel("");
        this.whiteCount.setBounds(10, 100, 360 - 10, 100);
        this.whiteCount.setFont(new Font("Arial", Font.BOLD, 32));
        this.whiteCount.setForeground(Color.WHITE);
        this.add(this.whiteCount);
    }

    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);

        this.blackCount.setText("Black: " + String.valueOf(this.board.count(Disk.black)));
        this.whiteCount.setText("White: " + String.valueOf(this.board.count(Disk.white)));

    }
}
