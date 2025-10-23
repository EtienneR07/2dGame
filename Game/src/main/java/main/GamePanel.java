package main;

import entity.Coordinates;
import entity.Entity;
import entity.Player;
import shared.Constants;
import shared.Direction;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 14;

    private final int fps = 60;

    private Thread gameThread;

    private final KeyHandler keyHandler = new KeyHandler();
    private final Player player = new Player();
    private final Coordinates screenCenter = new Coordinates(
            Constants.screenWidth / 2 - (Constants.tileSize / 2),
            Constants.screenHeight / 2 - (Constants.tileSize / 2));

    private final TileManager tileManager = new TileManager();

    public GamePanel() {
        this.setPreferredSize(new Dimension(Constants.screenWidth, Constants.screenHeight));
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

        tileManager.draw(graphics2, player.getCoordinates(), screenCenter);
        player.draw(graphics2, screenCenter);

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
        if (entity.getSpriteCounter() > 10) {
            if (entity.getSpriteNum() == 1) {
                entity.setSpriteNum(2);
            } else {
                entity.setSpriteNum(1);
            }

            entity.resetSpriteCounter();
        }
    }
}
