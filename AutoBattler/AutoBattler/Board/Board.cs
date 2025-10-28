namespace AutoBattler.Board;

public class Board
{
    public Tile[,] Tiles { get; }
    
    public int Rows { get; }
    public int Cols { get; }
    
    public Board(int rows, int cols)
    {
        Rows = rows;
        Cols = cols;
        Tiles = new Tile[rows, cols];
        
        for (var r = 0; r < rows; r++)
            for (var c = 0; c < cols; c++)
                Tiles[r, c] = new Tile(r, c);
    }
}