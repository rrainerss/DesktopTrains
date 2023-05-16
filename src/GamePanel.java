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
    private static float locomotiveAnimatedCoordinate = 260;
    private static int[] coordinateSteps = {210, 211, 212, 214, 217, 221, 226, 232, 239, 245, 250, 254, 257, 259, 260, 261, 263, 266, 270, 275, 281, 288, 294, 299, 303, 306, 308, 309, 310, 310};
    private static int[] coordinateLevels = {0, 14, 28};
    private static int currentCoordinateLevel = 14;
    private static int newCoordinateLevel = 14;
    private Image backgroundImage;
    private Image foregroundImage;
    private Image locomotiveImage;
    private Locomotive locomotive1;
    private long animationStartTime;

    // runs at start
    public GamePanel() {
        locomotive1 = new Locomotive("TE10", "icons/TE10_V4.png", 500, 1, 1500, 90, 1);
        animationStartTime = 0;

        loadBackgrounds();
        loadLocomotive(locomotive1);

        this.setFocusable(true);
        this.requestFocus();
    }

//    public static void addInputReader(JFrame gameFrame) {
//        InputReader inputReader = new InputReader();
//        gameFrame.addKeyListener(inputReader);
//    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        // Paint moving backgrounds
        graphics.drawImage(backgroundImage, background1XCoordinate, 0, null);
        graphics.drawImage(backgroundImage, background2XCoordinate, 0, null);
        graphics.drawImage(foregroundImage, foreground1XCoordinate, 0, null);
        graphics.drawImage(foregroundImage, foreground2XCoordinate, 0, null);
        graphics.drawImage(locomotiveImage, 150, (int)locomotiveAnimatedCoordinate, null);
    }

    public void updateBackgroundPosition() {
        // Update the position of the moving backgrounds
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

    private void loadBackgrounds() {
        try {
            // Load the image files
            BufferedImage bufferedBackground = ImageIO.read(new File("backgrounds/infinite_map_1_background.png"));
            BufferedImage bufferedForeground = ImageIO.read(new File("backgrounds/infinite_map_1_foreground.png"));

            // Scale the images to the desired size
            int width = bufferedBackground.getWidth();
            int height = bufferedBackground.getHeight();
            int scaledWidth = width * 2;
            int scaledHeight = height * 2;
            backgroundImage = bufferedBackground.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
            foregroundImage = bufferedForeground.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private void loadLocomotive(Locomotive locomotive1) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(locomotive1.spriteUrl));

            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            int scaledWidth = width * 2;
            int scaledHeight = height * 2;
            locomotiveImage = bufferedImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private void loadObstacles(Obstacle obstacle1) {

    }

    private static void returnSmoothTransitionLevel(int start, int end, int level){
        
    }
}
