import java.util.Random;
import java.awt.Color;
import java.awt.geom.*;

/**
 * Write a description of class BoxBall here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BoxBall
{
    public int xcord;
    public int ycord;
    public int speed;
    private Canvas canvas;
    private Ellipse2D.Double circle;
    Random rand = new Random();
    
    /**
     * Constructor for objects of class BoxBall
     */
    public BoxBall()
    {
        speed = rand.nextInt(11);
        xcord = rand.nextInt(501)+50;
        ycord = rand.nextInt(301)+100;
        
        //random color
        int r = rand.nextInt(225);
        int g = rand.nextInt(225);
        int b = rand.nextInt(225);
        Color randColor = new Color (r, g, b);
    }
    
    /**
     * Draws the ball
     */
    public void draw()
    {
        canvas = new Canvas("Box Ball", 600, 500);
        canvas.fillCircle(xcord, ycord, 15);
    }

    /**
     * Moves the ball by a random amount
     */
    public void move()
    {
        xcord += rand.nextInt(14)-7;
        ycord += rand.nextInt(14)-7;
         
        if (xcord == 0)
        {
            xcord += rand.nextInt(14)-7;
        }
         
        if (ycord == 0)
        {
            ycord += rand.nextInt(14)-7;
        }
    }
    
    
}
