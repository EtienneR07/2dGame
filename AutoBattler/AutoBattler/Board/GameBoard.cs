using AutoBattler.Board.Rendering;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;

namespace AutoBattler.Board;

public class GameBoard
{
    public Board Board  { get; }
    
    public BoardRenderer Renderer { get; }
    
    public GameBoard(int rows, int cols, float cellSize)
    {
        Board = new Board(rows, cols);
        Renderer = new BoardRenderer(Board, cellSize);
    }

    public void Draw(GraphicsDevice graphicsDevice, BasicEffect effect)
    {
        Renderer.Draw(graphicsDevice, effect);
    }
}