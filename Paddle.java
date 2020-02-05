import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle {
    // 1. Create a variable that will hold the Y axis of the paddle
    //    remember the paddle needs to have a constant Y axis because it shouldnt move vertically
    int y = 300;

    int ya = 0;
    // 2. Create a variable to hold the width of the paddle.
    int WIDTH = 40;
    // 3. Create as variable to hold the height of the paddle.
    int HEIGHT = 100;
    // create a variable for current speed
    int x = 1200;
    // create a variable for change in paddle velocity
    int xa = 0;
    // Makes a new game and also makes it private (I think);
    private Game game;

    public Paddle(Game game){
        this.game = game;
    }

    public void move() {
        if (y + ya > 0 && y + ya < game.getWidth() - HEIGHT)
            y = y + ya;
    }
    // This creates the paddle and fills it
    public void paint(Graphics2D g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
    // This detects whether the keyboard is being pressed
    public void keyReleased(KeyEvent e) {
        ya = 0;
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP)
            ya = -game.speed;
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            ya = game.speed;
    }    
    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
    public int getMiddleX(){
        return x;
    }


}
