package shared;

public enum Direction {
    UP(-1),
    DOWN(1),
    RIGHT(1),
    LEFT(-1);

    private final int modificator;

    Direction(int modificator) {
        this.modificator = modificator;
    }

    public int getModificator() {
        return modificator;
    }
}