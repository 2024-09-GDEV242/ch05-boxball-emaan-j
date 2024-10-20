import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Emaan Jaffer
 * @version 10/19/2024
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }
    
    /**
     * INSERT JAVA DOC COMMENT
     */
    public void boxBounce()
    {
        myCanvas.setVisible(true);
        myCanvas.drawLine(50, 400, 550, 400);
        myCanvas.drawLine(50, 100, 550, 100);
        myCanvas.drawLine(50, 100, 50, 400);
        myCanvas.drawLine(550, 100, 550, 400);
        
    }
    
    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
