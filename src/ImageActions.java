import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageActions extends Main{
    public static JLabel fullSizeBackgroundLabel(String path){
        ImageIcon originalBackgroundIcon = new ImageIcon(path);
        Image originalBackground = originalBackgroundIcon.getImage();
        Image resizedBackground = originalBackground.getScaledInstance(Main.window.getWidth(), Main.window.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedBackgroundIcon = new ImageIcon(resizedBackground);
        return new JLabel(resizedBackgroundIcon);
    }

    public static JLabel slideLabel(String path){
        ImageIcon originalLabelIcon = new ImageIcon(path);
        Image originalLabel = originalLabelIcon.getImage();
        Image resizedLabel = originalLabel.getScaledInstance(Main.window.getWidth(), Main.window.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedLabelIcon = new ImageIcon(resizedLabel);
        JLabel label = new JLabel(resizedLabelIcon);

        int loc = 0;

        while(true){
            label.setLocation(loc, 0);
            loc++;
            if(loc > 300){
                break;
            }
            try{
                Thread.sleep(200);
            }
            catch(Exception e){

            }
        }

        return label;
    }
}
