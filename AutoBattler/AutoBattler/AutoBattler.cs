using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;

namespace AutoBattler
{
    public class AutobattlerGame : Game
    {
        private BasicEffect _effect;
        private Matrix _world;
        private Matrix _view;
        private Matrix _projection;

        // Cube vertices
        private VertexPositionColor[] _cubeVertices;
        
        public AutobattlerGame()
        {
            Content.RootDirectory = "Content";
            IsMouseVisible = true;
        }

        protected override void Initialize()
        {
            _world = Matrix.Identity;
            _view = Matrix.CreateLookAt(new Vector3(3, 3, 5), Vector3.Zero, Vector3.Up);
            _projection = Matrix.CreatePerspectiveFieldOfView(
                MathHelper.PiOver4,
                GraphicsDevice.Viewport.AspectRatio,
                0.1f,
                100f
            );

            _cubeVertices = new VertexPositionColor[]
            {
                new VertexPositionColor(new Vector3(-1, 1, 1), Color.Red),
                new VertexPositionColor(new Vector3(1, 1, 1), Color.Red),
                new VertexPositionColor(new Vector3(-1, -1, 1), Color.Red),
                new VertexPositionColor(new Vector3(1, -1, 1), Color.Red),

                new VertexPositionColor(new Vector3(-1, 1, -1), Color.Green),
                new VertexPositionColor(new Vector3(1, 1, -1), Color.Green),
                new VertexPositionColor(new Vector3(-1, -1, -1), Color.Green),
                new VertexPositionColor(new Vector3(1, -1, -1), Color.Green),
            };

            base.Initialize();
        }

        protected override void LoadContent()
        {
            _effect = new BasicEffect(GraphicsDevice)
            {
                VertexColorEnabled = true,
                LightingEnabled = false,
                World = _world,
                View = _view,
                Projection = _projection
            };
        }

        protected override void Update(GameTime gameTime)
        {
            if (Keyboard.GetState().IsKeyDown(Keys.Escape))
                Exit();

            _effect.World = _world;

            base.Update(gameTime);
        }

        protected override void Draw(GameTime gameTime)
        {
            GraphicsDevice.Clear(Color.CornflowerBlue);

            foreach (var pass in _effect.CurrentTechnique.Passes)
            {
                pass.Apply();

                GraphicsDevice.DrawUserPrimitives(
                    PrimitiveType.LineList,
                    new VertexPositionColor[]
                    {
                        // Front face
                        _cubeVertices[0], _cubeVertices[1],
                        _cubeVertices[1], _cubeVertices[3],
                        _cubeVertices[3], _cubeVertices[2],
                        _cubeVertices[2], _cubeVertices[0],

                        // Back face
                        _cubeVertices[4], _cubeVertices[5],
                        _cubeVertices[5], _cubeVertices[7],
                        _cubeVertices[7], _cubeVertices[6],
                        _cubeVertices[6], _cubeVertices[4],

                        // Connect front and back
                        _cubeVertices[0], _cubeVertices[4],
                        _cubeVertices[1], _cubeVertices[5],
                        _cubeVertices[2], _cubeVertices[6],
                        _cubeVertices[3], _cubeVertices[7],
                    },
                    0,
                    12
                );
            }

            base.Draw(gameTime);
        }
    }
}
