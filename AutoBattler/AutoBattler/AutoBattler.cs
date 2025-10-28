using AutoBattler.Board;
using AutoBattler.entities;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;

namespace AutoBattler
{
    public class AutoBattlerGame : Game
    {
        private BasicEffect _effect;
        private Matrix _world;
        private Matrix _view;
        private Matrix _projection;

        private Cube _cube;
        private GameBoard _gameBoard;
        
        public AutoBattlerGame()
        {
            Content.RootDirectory = "Content";
            IsMouseVisible = true;
        }

        protected override void Initialize()
        {
            _world = Matrix.Identity;
            _view = Matrix.CreateLookAt(new Vector3(4, 10, 10), new Vector3(4, 0, 5), Vector3.Up);
            _projection = Matrix.CreatePerspectiveFieldOfView(
                MathHelper.PiOver4,
                GraphicsDevice.Viewport.AspectRatio,
                0.1f,
                100f
            );

            _cube =  new Cube();
            _gameBoard = new GameBoard(8, 8, 1f);
            
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

                _gameBoard.Draw(GraphicsDevice, _effect);
            }

            base.Draw(gameTime);
        }
    }
}
