import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Main {
    public static String appVersion = "1.0";
//    public static JFrame window = new CustomFrame(640, 400);

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();

        // Set the window properties
        gameFrame.setTitle("My Game");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(800, 600);
        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);

        // Make the GameFrame visible
        gameFrame.setVisible(true);
        gameFrame.start();

        System.out.println("Main method ran");
    }
}