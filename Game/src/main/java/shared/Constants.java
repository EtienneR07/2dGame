package shared;

public class Constants {
    public static final int orignalTileSize = 32;
    public static final int scale = 2;
    public static final int tileSize = orignalTileSize * scale;
    public static final int maxScreenCol = 16;
    public static final int maxScreenRow = 14;
    public static final int screenWidth = tileSize * maxScreenCol;
    public static final int screenHeight = tileSize * maxScreenRow;

    public static final int maxWorldCol = 64;
    public static final int maxWorldRow = 64;

    public static final int worldWidth = maxWorldCol * tileSize;
    public static final int worldHeight = maxWorldRow * tileSize;
}
