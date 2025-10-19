package main;

import entity.Entity;
import entity.Player;
import shared.Direction;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // 32 x 32 tile
    private final int orignalTileSize = 32;
    private final int scale = 2;

    // 48 x 48
    private final int tileSize = orignalTileSize * scale;
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 14;

    // 576
    private final int screenWidth = tileSize * maxScreenCol;
    // 768
    private final int screenHeight = tileSize * maxScreenRow;
    private final int fps = 60;

    private Thread gameThread;
    private final KeyHandler keyHandler = new KeyHandler();

    private final Player player = new Player();

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / fps;
        var delta = 0D;
        var lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        updateEntity(player);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        var graphics2 = (Graphics2D) graphics;
        player.draw(graphics2, tileSize);

        graphics2.dispose();
    }

    private void updateEntity(Entity entity) {
        if (!keyHandler.upPressed && !keyHandler.downPressed && !keyHandler.rightPressed && !keyHandler.leftPressed)
            return;

        if (keyHandler.upPressed)
            entity.updateY(Direction.UP);

        else if (keyHandler.downPressed)
            entity.updateY(Direction.DOWN);

        else if (keyHandler.rightPressed)
            entity.updateX(Direction.RIGHT);

        else
            entity.updateX(Direction.LEFT);

        entity.incrementSpriteCounter();
        if (entity.getSpriteCounter() > 20) {
            if (entity.getSpriteNum() == 1) {
                entity.setSpriteNum(2);
            } else {
                entity.setSpriteNum(1);
            }

            entity.resetSpriteCounter();
        }
    }
}
