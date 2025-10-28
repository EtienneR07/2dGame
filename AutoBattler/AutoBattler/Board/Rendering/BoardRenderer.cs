using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;

namespace AutoBattler.Board.Rendering;

public class BoardRenderer
{
    private readonly TileRenderer[,] _tileRenderers;
    private readonly int _rows;
    private readonly int _cols;
    
    public BoardRenderer(Board board, float cellSize = 1f)
    {
        _rows = board.Rows;
        _cols = board.Cols;

        _tileRenderers = new TileRenderer[_rows, _cols];

        for (var r = 0; r < _rows; r++)
        {
            for (var c = 0; c < _cols; c++)
            {
                if (r == 0 && c == 0)
                {
                    _tileRenderers[r, c] = new TileRenderer(board.Tiles[r, c], Color.Red, cellSize);
                    continue;
                }
                _tileRenderers[r, c] = new TileRenderer(board.Tiles[r, c], Color.Green, cellSize);
            }
        }
    }
    
    public void Draw(GraphicsDevice graphicsDevice, BasicEffect effect)
    {
        for (var r = 0; r < _rows; r++)
            for (var c = 0; c < _cols; c++)
                _tileRenderers[r, c].Draw(graphicsDevice, effect);
    }
}