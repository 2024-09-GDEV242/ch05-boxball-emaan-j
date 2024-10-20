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
    private Color randColor;
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
        canvas = new Canvas("Box Ball", 600, 500);
    }
    
    /**
     * Draws the ball
     */
    public void draw()
    {
        circle = new Ellipse2D.Double(xcord-15, ycord-15, 30, 20);
        canvas.setForegroundColor(randColor);
        canvas.fill(circle);
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
