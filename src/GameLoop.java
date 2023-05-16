class GameLoop implements Runnable {
    private boolean running = true;
    private GamePanel gamePanel;
    private InputReader inputReader;
    private int sleepTime = 16;
    private int obstacleMillis;
    private double obstacleDelay = 1500;
    private int speedMillis;
    private double speedDelay = 10000;

    public GameLoop(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.inputReader = new InputReader();
        this.gamePanel.addKeyListener(inputReader);
    }

    //Runs continuously
    public void run() {
        System.out.println("Game loop is running");
        while (running) {
            //Position and animation updates
            gamePanel.updateBackgroundPosition();
            gamePanel.updateObstaclePosition();
            gamePanel.locomotivePositionAnimation();
            gamePanel.repaint();

            //Obstacle generator
            obstacleMillis += 16;
            if(obstacleMillis >= obstacleDelay) {
                new GeneratedObstacle();
                obstacleMillis = 0;
            }

            //Speed-up logic of game
            speedMillis += 16;
            if(speedMillis >= speedDelay) {
                if(sleepTime > 5) {
                    sleepTime -= 1;
                    System.out.println(sleepTime);
                    speedDelay = speedDelay * (1 + (1 / (double)sleepTime));
                }
                speedMillis = 0;
            }

            try {
                //Program takes a little break
                Thread.sleep(sleepTime);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void stop() {
        running = false;
    }
}