package entity;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void moveX(int distanceX) {
        this.x += distanceX;
    }

    public int getY() {
        return y;
    }

    public void moveY(int distanceY) {
        this.y += distanceY;
    }
}
