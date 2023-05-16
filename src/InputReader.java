import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputReader implements KeyListener {
    private GamePanel gamePanel;
    private boolean VK_UP_Pressed;
    private boolean VK_DOWN_Pressed;

    //Return button state
    public boolean VK_UP_State() {
        return VK_UP_Pressed;
    }
    public boolean VK_DOWN_State() {
        return VK_DOWN_Pressed;
    }

    //Override default method for keyPressed event
    @Override
    public void keyPressed(KeyEvent event) {
        //Up arrow pressed
        if (event.getKeyCode() == KeyEvent.VK_UP && this.VK_UP_Pressed == false) {
            this.VK_UP_Pressed = true;
            GamePanel.updateLocomotivePosition("up");
        }
        //Down arrow pressed
        if (event.getKeyCode() == KeyEvent.VK_DOWN && this.VK_DOWN_Pressed == false) {
            this.VK_DOWN_Pressed = true;
            GamePanel.updateLocomotivePosition("down");
        }
    }

    //Override default method for keyReleased event
    @Override
    public void keyReleased(KeyEvent event) {
        //Up arrow released
        if (event.getKeyCode() == KeyEvent.VK_UP && this.VK_UP_Pressed == true) {
            this.VK_UP_Pressed = false;
        }
        //Down arrow released
        if (event.getKeyCode() == KeyEvent.VK_DOWN && this.VK_DOWN_Pressed == true) {
            this.VK_DOWN_Pressed = false;
        }
    }

    //Not used yet
    @Override
    public void keyTyped(KeyEvent event) {
        //
    }
}
