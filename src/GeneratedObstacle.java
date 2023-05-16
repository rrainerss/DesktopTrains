import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratedObstacle extends JPanel{
    public static List<Obstacle> obstacles = new ArrayList<>();
    public static int previousLevel = -1;
    public static int randomLevel = -1;
    public GamePanel gamePanel;
    private int obstacleCount;

    //Add a new Obstacle object to arraylist when called, position is chosen (mostly) randomly
    public GeneratedObstacle() {
        Random random = new Random();
        if(previousLevel == -1) {
            previousLevel = 1;
            randomLevel = 1;
        }
        while(previousLevel == randomLevel) {
            randomLevel = random.nextInt(3);
        }
        previousLevel = randomLevel;
        Obstacle obstacle = new Obstacle("Rail split", "icons/rail_split.png", randomLevel, 30);
        obstacles.add(obstacle);
        obstacleCount++;
        if(obstacles.size() > 5) {
            Obstacle firstObstacle = obstacles.get(0);
            obstacles.remove(firstObstacle);
        }
    }
}
