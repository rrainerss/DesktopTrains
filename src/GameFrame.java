import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.io.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GameFrame extends JFrame {
    private GamePanel gamePanel;
    private GameLoop gameLoop;

    public GameFrame() {
        // Set up the game panel
        gamePanel = new GamePanel();
        gamePanel.setPreferredSize(new Dimension(640, 400));
        getContentPane().add(gamePanel);

        // Set up the game loop
        gameLoop = new GameLoop(gamePanel);
    }

    public void start() {
        // Start the game loop
        Thread thread = new Thread(gameLoop);
        thread.start();
    }
}