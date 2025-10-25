using Microsoft.Xna.Framework;

namespace AutoBattler;

public class GameManager : IDisposable
{
    private AutobattlerGame _game;
    private ScreenManager _screenManager;
    private GraphicsDeviceManager _graphics;
    
    public GameManager()
    {
        _game = new AutobattlerGame();
        _graphics = new GraphicsDeviceManager(_game);
        _screenManager = new ScreenManager(_graphics);
        
        _screenManager.SetTestScreen();
    }

    public void Run()
    {
        _game.Run();
    }

    public void Dispose()
    {
        _game.Dispose();
        _graphics.Dispose();
    }
}