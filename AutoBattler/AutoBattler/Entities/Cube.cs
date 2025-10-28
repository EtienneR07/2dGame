using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Vector3 = System.Numerics.Vector3;

namespace AutoBattler.entities;

public class Cube : Entity
{
    public VertexPositionColor[] Vertices { get; }

    public Cube()
    {
        Vertices =
        [
            new VertexPositionColor(new Vector3(-1, 1, 1), Color.Red),
            new VertexPositionColor(new Vector3(1, 1, 1), Color.Red),
            new VertexPositionColor(new Vector3(-1, -1, 1), Color.Red),
            new VertexPositionColor(new Vector3(1, -1, 1), Color.Red),

            new VertexPositionColor(new Vector3(-1, 1, -1), Color.Green),
            new VertexPositionColor(new Vector3(1, 1, -1), Color.Green),
            new VertexPositionColor(new Vector3(-1, -1, -1), Color.Green),
            new VertexPositionColor(new Vector3(1, -1, -1), Color.Green)
        ];
    }
}