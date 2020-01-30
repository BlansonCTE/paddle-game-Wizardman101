import java.awt.Graphics2D;
import java.awt.Rectangle;
// This creates the class
class Ball{
    
    int x = 0,  y = 0, xVelocity = 1, yVelocity = 1;
    private static final int DIAMETER = 30;
    private Game game;

    public Ball(Game game){
        this.game = game;
    }
    void move(){
        // Left wall hit
        if (x < 0)
            xVelocity = game.speed;
        // Right wall hit
        if (x + xVelocity > game.getWidth()- DIAMETER)
            xVelocity = -game.speed;
        // Top wall hit
        if (y < 0)
            yVelocity = game.speed;
        if (y +xVelocity > game.getHeight() - DIAMETER)
            game.gameOver();
        if (collision()){
            yVelocity = -game.speed;
            game.speed++;
            y = game.paddle.getTopY() - DIAMETER;
    }


        // Move ball
        x = x + xVelocity;
        y = y + yVelocity;

    }
    public void paint(Graphics2D g){
        g.fillOval(x, y, DIAMETER, DIAMETER);
    
    }
    private boolean collision(){
        return game.paddle.getBounds().intersects(getBounds());
    }
    public Rectangle getBounds(){
        return new Rectangle(x, y, DIAMETER, DIAMETER);

    }
}




