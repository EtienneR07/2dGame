package entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {
    public Player() {
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/girl_up_1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/girl_up_2.png")));

            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/girl_down_1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/girl_down_2.png")));

            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/girl_right_1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/girl_right_2.png")));

            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/girl_left_1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/girl_left_2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2, int tileSize) {
        BufferedImage image = null;

        switch (direction) {
            case UP -> {
                if (spriteNum == 1)
                    image = up1;
                else
                    image = up2;

            }
            case DOWN -> {
                if (spriteNum == 1)
                    image = down1;
                else
                    image = down2;
            }
            case RIGHT -> {
                if (spriteNum == 1)
                    image = right1;
                else
                    image = right2;
            }
            case LEFT -> {
                if (spriteNum == 1)
                    image = left1;
                else
                    image = left2;
            }
        }

        graphics2.drawImage(image, x, y, tileSize, tileSize, null);
    }
}
