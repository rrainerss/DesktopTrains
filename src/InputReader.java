import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputReader implements KeyListener {
    private GamePanel gamePanel;
    private boolean VK_UP_Pressed;
    private boolean VK_DOWN_Pressed;

    public boolean VK_UP_State() {
        return VK_UP_Pressed;
    }

    public boolean VK_DOWN_State() {
        return VK_DOWN_Pressed;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        //up arrow pressed
        if (event.getKeyCode() == KeyEvent.VK_UP && this.VK_UP_Pressed == false) {
            System.out.println("UP ARROW pressed");
            this.VK_UP_Pressed = true;
            GamePanel.updateLocomotivePosition("up");
        }
        //down arrow pressed
        if (event.getKeyCode() == KeyEvent.VK_DOWN && this.VK_DOWN_Pressed == false) {
            System.out.println("DOWN ARROW pressed");
            this.VK_DOWN_Pressed = true;
            GamePanel.updateLocomotivePosition("down");
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        //up arrow released
        if (event.getKeyCode() == KeyEvent.VK_UP && this.VK_UP_Pressed == true) {
            System.out.println("UP ARROW released");
            this.VK_UP_Pressed = false;
        }
        //down arrow released
        if (event.getKeyCode() == KeyEvent.VK_DOWN && this.VK_DOWN_Pressed == true) {
            System.out.println("DOWN ARROW released");
            this.VK_DOWN_Pressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent event) {
        //
    }
}
