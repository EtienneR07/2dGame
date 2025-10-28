using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;

namespace AutoBattler.Board.Rendering;

public class TileRenderer
{
    private VertexPositionTexture[] Vertices { get; set; }
    
    private readonly float _cellSize;
    private readonly Vector3 _position;
    private readonly Color _color;
    
    public TileRenderer(Tile tile, Color color, float cellSize = 1f)
    {
        this._cellSize = cellSize;
        _position = new Vector3(tile.Col * cellSize, 0, tile.Row * cellSize);
        this._color = color;

        GenerateVertices();
    }
    
    private void GenerateVertices()
    {
        Vertices = new VertexPositionTexture[6];

        var topLeft = _position;
        var topRight= _position + new Vector3(_cellSize, 0, 0);
        var bottomRight = _position + new Vector3(_cellSize, 0, _cellSize);
        var bottomLeft = _position + new Vector3(0, 0, _cellSize);
        
        Vertices[0] = new VertexPositionTexture(topLeft, new Vector2(0, 0));
        Vertices[1] = new VertexPositionTexture(bottomRight, new Vector2(1, 1));
        Vertices[2] = new VertexPositionTexture(bottomLeft, new Vector2(0, 1));

        Vertices[3] = new VertexPositionTexture(topLeft, new Vector2(0, 0));
        Vertices[4] = new VertexPositionTexture(topRight, new Vector2(1, 0));
        Vertices[5] = new VertexPositionTexture(bottomRight, new Vector2(1, 1));
    }
    
    public void Draw(GraphicsDevice graphicsDevice, BasicEffect effect)
    {
        foreach (var pass in effect.CurrentTechnique.Passes)
        {
            pass.Apply();
            graphicsDevice.DrawUserPrimitives(PrimitiveType.TriangleList, Vertices, 0, 2);
        }
    }
}