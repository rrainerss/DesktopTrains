import javax.swing.*;
import java.awt.*;

public class CustomFrame extends JFrame{
    CustomFrame(int width, int height){
        ImageIcon appIcon = new ImageIcon("icons/game_icon.png");
        this.setIconImage(appIcon.getImage());
        this.setTitle("Desktop Trains " + Main.appVersion);
        this.setSize(width, height);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(30, 30, 30));
    }

    public static void initialiseFrame(JFrame window){
        window.setVisible(true);
    }
}
