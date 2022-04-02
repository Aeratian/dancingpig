/**
 * TravelingPig.java
 * 
 * A class representing a pig that travels from back and forth from one 
 * side of the canvas to another as its dance. Each TravelingPig has a
 * position (x and y),  a direction (Point), a Color, a boolean to determine 
 * which direction the TravelingPig is traveling in, and a follower. There
 * are 2 constructors (3 args and 4 args). Each step is either a forward or
 * backwards move depending on the movingForward boolean.
 * 
 * @author Ian Youn
 * @version 1.0
 * @since 11/20/2020
 */

import java.awt.Font;
import java.awt.Color;

public class TravelingPig extends DancingPig implements Leader
{
    /** A boolean representing the direction the TravelingPig is traveling in.    */
    private boolean movingForward;

    /** The follower of the TravelingPig.    */
    private DancingPig follower;

    /**
     * Creates a TravelingPig object. This is a three-args constructor.
     * The parameters represent the x-coordinate, y-coordinate, and color of the 
     * TravelingPig.
     * @param x     The x-coordinate of TravelingPig's position.
     * @param y     The y-coordinate of TravelingPig's position.
     * @param c     The color of TravelingPig.
     */
    public TravelingPig (int x, int y, Color c)
    {
        super(x, y, c);
        movingForward = true;
    }

     /**
     * Creates a TravelingPig object. This is a four-args constructor.
     * The parameters represent the x-coordinate, y-coordinate, color, and 
     * direction of the TravelingPig.
     * @param x     The x-coordinate of TravelingPig's position.
     * @param y     The y-coordinate of TravelingPig's position.
     * @param c     The color of TravelingPig.
     * @param p     The direction of the TravelingPig.
     */
    public TravelingPig (int x, int y, Color c, Point p)
    {
        super(x, y, c, p);
        movingForward = true;
    }

    /**
     * Gets the current location of the TravelingPig
     * @return      The current location of the TravelingPig
     */
    public Point getLocation ( )
    {
        return new Point(getX(), getY());
    }

    /**
     * Gets the current direction of the TravelingPig
     * @return      The current direction of the TravelingPig
     */
    public Point getDirection ( )
    {
        return super.getDirection();
    }

    /**
     * Adds a follower to the TravelingPig
     */
    public void addFollower (DancingPig pig)
    {
        follower = pig;
    }

    /**
     * Removes a follower from the Traveling Pig.
     */
    public void removeFollower (DancingPig pig)
    {
        follower = null;
    }

    /**
     * Causes the TravelingPig and its follower to perform one
     * dance step.
     */
    public void step ( )
    {
       if(movingForward)
       {
            if(!follower.moveForward(-64))
            {
                movingForward = !movingForward;
                follower.moveForward(64);
                moveForward(-64);
            }
            else
            {
                moveForward(64);
            }
       }
       else
       {
            if(!moveForward(-64))
            {
                movingForward = !movingForward;
                follower.moveForward(-64);
                moveForward(64);
            }
            else
            {
                follower.moveForward(64);
            }
       }
    }

    /**
     * Overrides the draw method so a "L" is printed 
     * on the TravelingPig.
     */
    public void draw ( )
    {
        super.draw();
        Font font = new Font("Arial", Font.BOLD, 30);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setFont(font);
        StdDraw.text(getX(), getY(), "L");
    }
}
