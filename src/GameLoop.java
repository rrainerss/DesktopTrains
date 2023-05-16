class GameLoop implements Runnable {
    private boolean running = true;
    private GamePanel gamePanel;
    private InputReader inputReader;

    public GameLoop(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.inputReader = new InputReader();
        this.gamePanel.addKeyListener(inputReader);
    }

    //runs continuously
    public void run() {
        System.out.println("Run method ran");
        while (running) {

            this.inputReader.VK_UP_State();

            gamePanel.updateBackgroundPosition();
            gamePanel.locomotivePositionAnimation();
            gamePanel.repaint();

            try {
                Thread.sleep(16);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

//    public void train

    public void stop() {
        running = false;
    }
}