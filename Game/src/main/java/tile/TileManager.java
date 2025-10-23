package tile;

import entity.Coordinates;
import shared.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TileManager {
    private final Tile[] tiles;
    private final int mapTileNum[][];

    public TileManager() {
        tiles = new Tile[10];
        mapTileNum = new int[Constants.maxWorldCol][Constants.maxWorldRow];

        initImages();
        loadMap("/maps/map1.txt");
    }

    public void loadMap(String fileName) {
        try {
            var is = getClass().getResourceAsStream(fileName);
            var bufferedReader = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < Constants.maxWorldCol && row < Constants.maxWorldRow) {
                var line = bufferedReader.readLine();

                while (col < Constants.maxWorldCol) {
                    var numbers = line.toCharArray();
                    var num = Integer.parseInt("%s".formatted(numbers[col]));

                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == Constants.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }

            bufferedReader.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void initImages() {
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/ground_tile_1.png"));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_tile_1.png"));

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_tile_1.png"));

            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth_tile_1.png"));

            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree_tile_1.png"));

            tiles[5] = new Tile();
            tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand_tile_1.png"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void draw(Graphics2D g2, Coordinates playerCoordinates, Coordinates screenCenter) {
        int tileSize = Constants.tileSize;

        int startCol = Math.max(0, (playerCoordinates.getX() - screenCenter.getX()) / tileSize);
        int endCol = Math.min(Constants.maxWorldCol, (playerCoordinates.getX() + screenCenter.getX()) / tileSize + 1) + 1;

        int startRow = Math.max(0, (playerCoordinates.getY() - screenCenter.getY()) / tileSize);
        int endRow = Math.min(Constants.maxWorldRow, (playerCoordinates.getY() + screenCenter.getY()) / tileSize + 1) + 1;

        for (int row = startRow; row < endRow; row++) {
            for (int col = startCol; col < endCol; col++) {

                int image = mapTileNum[row][col];

                int worldX = col * tileSize;
                int worldY = row * tileSize;

                int screenX = worldX - playerCoordinates.getX() + screenCenter.getX();
                int screenY = worldY - playerCoordinates.getY() + screenCenter.getY();

                g2.drawImage(
                        tiles[image].image,
                        screenX, screenY,
                        tileSize, tileSize,
                        null
                );
            }
        }
    }

}
