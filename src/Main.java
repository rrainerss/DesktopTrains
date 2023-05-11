import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Main {
    public static String appVersion = "1.0";
    public static JFrame window = new CustomFrame(640, 400);

    public static void main(String[] args) {

        Border border = BorderFactory.createLineBorder(new Color(0, 0, 0));
        ImageIcon image = new ImageIcon("icons/game_icon.png");

        startScreen(window);

//        label.setText("This text aint right");
//        label.setIcon(image);
//        label.setHorizontalTextPosition(JLabel.CENTER);
//        label.setVerticalTextPosition(JLabel.TOP);
//        label.setForeground(new Color(255, 255, 255));
//        label.setFont(new Font("Calibri", Font.ITALIC, 16));
        //bauhaus 93 font in photoshop
//        label.setIconTextGap(25);
//        label.setBorder(border);
//        label.setVerticalAlignment(JLabel.TOP);
//        label.setHorizontalAlignment(JLabel.LEFT);
//        label.setBackground(Color.orange);
//        label.setOpaque(true);
//        label.setBounds(0, 0, 100, 100);

//        window.add(label);

    }

    public static void displayElement(int width, int height, int x, int y){

    }

    public static void startScreen(JFrame window){

        JLabel backgroundLabel = ImageActions.fullSizeBackgroundLabel("backgrounds/start_screen.png");
        JLabel backgroundLabelText = ImageActions.fullSizeBackgroundLabel("backgrounds/start_screen_text.png");
        backgroundLabel.setBounds(0, 0, 640, 400);
        backgroundLabelText.setBounds(0, 0, 640, 400);

        JPanel panel = new JPanel(null);

        panel.setOpaque(false);
        backgroundLabelText.setOpaque(false);
        backgroundLabel.setOpaque(false);

        panel.add(backgroundLabelText);
        panel.add(backgroundLabel);


        window.add(panel);


        CustomFrame.initialiseFrame(window);
    }
}