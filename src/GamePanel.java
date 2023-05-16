import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    private int background1XCoordinate = 0;
    private int foreground1XCoordinate = 0;
    private int background2XCoordinate = 640;
    private int foreground2XCoordinate = 640;
    //Manually predefined coordinate steps for smooth, hopefully efficient animations
    private static float locomotiveAnimatedCoordinate = 260;
    private static int[] coordinateSteps = {210, 211, 212, 214, 217, 221, 226, 232, 239, 245, 250, 254, 257, 259, 260, 261, 263, 266, 270, 275, 281, 288, 294, 299, 303, 306, 308, 309, 310, 310};
    private static int[] coordinateLevels = {0, 14, 28};
    private static int currentCoordinateLevel = 14;
    private static int newCoordinateLevel = 14;
    private BufferedImage bufferedImage;
    private Image backgroundImage;
    private Image foregroundImage;
    private Image locomotiveImage;
    private Locomotive locomotive1;
    private Image obstacleImage1;
    private long animationStartTime;

    //Runs at start of game, creates objects, calls starter methods
    public GamePanel() {
        locomotive1 = new Locomotive("TE10", "icons/TE10_V4.png", 500, 1, 1500, 90, 1);
        animationStartTime = 0;

        loadBackgrounds();
        loadLocomotive(locomotive1);

        this.setFocusable(true);
        this.requestFocus();
    }

    //Java swing built-in method to draw components
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        //Draw backgrounds
        graphics.drawImage(backgroundImage, background1XCoordinate, 0, null);
        graphics.drawImage(backgroundImage, background2XCoordinate, 0, null);
        graphics.drawImage(foregroundImage, foreground1XCoordinate, 0, null);
        graphics.drawImage(foregroundImage, foreground2XCoordinate, 0, null);

        //Iterate through obstacles and draw them
        if(GeneratedObstacle.obstacles != null) {
            for (Obstacle obstacle : GeneratedObstacle.obstacles) {
                graphics.drawImage(obstacle.image, obstacle.obstacleXCoordinate, coordinateSteps[coordinateLevels[obstacle.level]] + obstacle.obstacleYOffset, null);
            }
        }

        //Draw locomotive
        graphics.drawImage(locomotiveImage, 150, (int)locomotiveAnimatedCoordinate, null);
    }

    //Move obstacles at a constant rate (same as backgrounds)
    public void updateObstaclePosition() {
        for (Obstacle obstacle : GeneratedObstacle.obstacles) {
            obstacle.obstacleXCoordinate -= 3;
        }
    }

    //Move backgrounds to create the illusion of a moving train
    public void updateBackgroundPosition() {
        foreground1XCoordinate -= 3;
        if(foreground1XCoordinate < -640){
            foreground1XCoordinate = 0;
        }
        foreground2XCoordinate -= 3;
        if(foreground2XCoordinate < 0){
            foreground2XCoordinate = 640;
        }
        background1XCoordinate -= 1;
        if(background1XCoordinate < -640){
            background1XCoordinate = 0;
        }
        background2XCoordinate -= 1;
        if(background2XCoordinate < 0){
            background2XCoordinate = 640;
        }
    }

    //Jump locomotive through the coordinate levels
    public static void updateLocomotivePosition(String direction) {
        if(currentCoordinateLevel < 14) {
            if(direction.matches("down")) {
                newCoordinateLevel += 14;
            }
        }
        else if (currentCoordinateLevel > 14) {
            if(direction.matches("up")) {
                newCoordinateLevel -= 14;
            }
        }
        else {
            if(direction.matches("down")) {
                newCoordinateLevel += 14;
            }
            else if(direction.matches("up")) {
                newCoordinateLevel -= 14;
            }
        }
    }

    //Animate the locomotive position change
    public static void locomotivePositionAnimation() {
        if(newCoordinateLevel > currentCoordinateLevel) {
            currentCoordinateLevel++;
            locomotiveAnimatedCoordinate = coordinateSteps[currentCoordinateLevel];
        }
        else if(newCoordinateLevel < currentCoordinateLevel) {
            currentCoordinateLevel--;
            locomotiveAnimatedCoordinate = coordinateSteps[currentCoordinateLevel];
        }
    }

    //Load assets into images
    private void loadBackgrounds() {
        backgroundImage = loadBufferedImage("backgrounds/infinite_map_1_background.png", 2);
        foregroundImage = loadBufferedImage("backgrounds/infinite_map_1_foreground.png", 2);
    }
    private void loadLocomotive(Locomotive locomotive) {
        locomotiveImage = loadBufferedImage(locomotive.spriteUrl, 2);
    }

    //Load images from file location, taking scale into account
    public Image loadBufferedImage(String url, int scale) {
        Image loadedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(url));

            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            int scaledWidth = width * scale;
            int scaledHeight = height * scale;
            loadedImage = bufferedImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return loadedImage;
    }

    //Future plans
    private static void returnSmoothTransitionLevel(int start, int end, int level){
        
    }
}
