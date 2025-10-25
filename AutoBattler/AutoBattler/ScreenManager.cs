using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;

namespace AutoBattler;

public class ScreenManager(GraphicsDeviceManager graphics)
{
    private GraphicsDeviceManager _graphics = graphics;

    public void SetTestScreen()
    {
        var screenWidth = GraphicsAdapter.DefaultAdapter.CurrentDisplayMode.Width - 100;
        var screenHeight = GraphicsAdapter.DefaultAdapter.CurrentDisplayMode.Height - 100;
        
        _graphics.PreferredBackBufferWidth = screenWidth;
        _graphics.PreferredBackBufferHeight = screenHeight;
        
        _graphics.IsFullScreen = false;

        _graphics.ApplyChanges();
    }
}