using System;

namespace AutoBattler
{
    public static class Program
    {
        [STAThread]
        static void Main()
        {
            using var gameManager = new GameManager();
            
            gameManager.Run();
        }
    }
}