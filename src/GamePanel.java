import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private int background1XCoordinate = 0;
    private int background2XCoordinate = 640;
    private Image image;

    public GamePanel() {
        try{
            // Load the image file
            BufferedImage bufferedImage = ImageIO.read(new File("backgrounds/infinite_map_1.png"));

            // Scale the image to the desired size
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            int scaledWidth = width * 2;
            int scaledHeight = height * 2;
            image = bufferedImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the rectangle at its current position
//        g.setColor(Color.RED);
//        g.fillRect(x, 200, 50, 50);
        g.drawImage(image, background1XCoordinate, 0, null);
        g.drawImage(image, background2XCoordinate, 0, null);
    }

    public void update() {
        // Update the position of the background
        background1XCoordinate -= 5;
        if(background1XCoordinate < -640){
            background1XCoordinate = 0;
        }
        background2XCoordinate -= 5;
        if(background2XCoordinate < 0){
            background2XCoordinate = 640;
        }
    }
}
