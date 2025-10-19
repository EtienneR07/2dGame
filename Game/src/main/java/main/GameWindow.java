package main;

import javax.swing.*;

public class GameWindow {
    private final JFrame window;

    public GameWindow() {
        window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("First 2D Game");
    }

    public void addPanel(JPanel panel) {
        window.add(panel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
