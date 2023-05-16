import java.awt.*;

public class Obstacle extends GamePanel {
    String name;
    String spriteUrl;
    Image image;
    int level;
    int obstacleYOffset;
    int obstacleXCoordinate;

    //Obstacle object constructor
    public Obstacle(String name, String spriteUrl, int level, int obstacleYOffset) {
        this.name = name;
        this.spriteUrl = spriteUrl;
        this.image = loadBufferedImage(spriteUrl, 2);
        this.level = level;
        this.obstacleYOffset = obstacleYOffset;
        obstacleXCoordinate = 640;
    }
}
