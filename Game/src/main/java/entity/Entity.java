package entity;

import shared.Direction;

import java.awt.image.BufferedImage;

public class Entity {
    protected Coordinates coordinates;

    protected int speed;

    protected int level;

    protected int intelligence;
    protected int strength;

    protected int spriteCounter = 0;
    protected int spriteNum = 1;

    protected BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    protected Direction direction = Direction.UP;

    public void updateX(Direction direction) {
        this.direction = direction;
        this.coordinates.moveX(direction.getModificator() * speed);
    }

    public void updateY(Direction direction) {
        this.direction = direction;
        this.coordinates.moveY(direction.getModificator() * speed);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getSpriteCounter() {
        return spriteCounter;
    }

    public void incrementSpriteCounter() {
        this.spriteCounter++;
    }

    public void resetSpriteCounter() {
        this.spriteCounter = 0;
    }

    public int getSpriteNum() {
        return spriteNum;
    }

    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }
}
