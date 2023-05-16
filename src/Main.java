import javax.swing.*;

public class Main {
    public static String appVersion = "1.0";

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();

        //Set the window properties
        gameFrame.setTitle("My Game");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(800, 600);
        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setResizable(false);
        gameFrame.setTitle("Desktop Trains " + appVersion);
        ImageIcon appIcon = new ImageIcon("icons/game_icon.png");
        gameFrame.setIconImage(appIcon.getImage());

        //Make the GameFrame visible
        gameFrame.setVisible(true);
        gameFrame.start();
    }
}