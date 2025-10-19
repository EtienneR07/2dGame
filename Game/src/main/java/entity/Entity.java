package entity;

import shared.Direction;

import java.awt.image.BufferedImage;

public class Entity {
    protected int x;
    protected int y;
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
        this.x = x + (direction.getModificator() * speed);
    }

    public void updateY(Direction direction) {
        this.direction = direction;
        this.y = y + (direction.getModificator() * speed);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
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
