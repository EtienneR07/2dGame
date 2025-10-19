package main;


public class Main {
    public static void main(String[] args) {
        var window = new GameWindow();

        var gamePanel = new GamePanel();

        window.addPanel(gamePanel);

        gamePanel.startGameThread();
    }
}