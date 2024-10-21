import java.awt.Color;
import java.util.ArrayList;

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
     * Draws a box inside the canvas.
     */
    public void boxBounce(int ballAmount)
    {
        ArrayList<BoxBall> boxList = new ArrayList<>();
        
        myCanvas.setVisible(true);
        myCanvas.drawLine(50, 400, 550, 400);
        myCanvas.drawLine(50, 100, 550, 100);
        myCanvas.drawLine(50, 100, 50, 400);
        myCanvas.drawLine(550, 100, 550, 400);
        
        for (int i = 0; i < ballAmount; i++)
        {
            BoxBall boxBall = new BoxBall();
            boxList.add(boxBall);
        }
        
        boolean finished = false;
        while(!finished)
        {
            for (int i = 0; i < boxList.size(); i++)
            {
                BoxBall showBall = boxList.get(i);
                showBall.move();
                showBall.draw();
                //reboundings
                if (showBall.xcord == 45 || showBall.xcord == 545)
                {
                    showBall.speed *= -1;
                }
         
                if (showBall.ycord == 95 || showBall.ycord == 395)
                {
                    showBall.speed *= -1;
                }
                
            }
        }
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
