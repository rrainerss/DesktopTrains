class GameLoop implements Runnable {
    private boolean running = true;
    private GamePanel gamePanel;

    public GameLoop(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void run() {
        System.out.println("Run method ran");
        while (running) {

            // Update the game state
            gamePanel.update();

            // Repaint the game panel to update the display
            gamePanel.repaint();

            try {
                // Sleep for 16 milliseconds to keep the loop running at 60 frames per second
                Thread.sleep(16);
            } catch (InterruptedException e) {
                // Handle the exception if necessary
            }
        }
    }

    public void stop() {
        running = false;
    }
}