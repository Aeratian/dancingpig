/**
 * TwirlingPig.java
 * 
 * A class representing a pig that rotates clockwise with each dance step.
 * Each TwirlingPig has a position (x and y), a direction (Point), and a Color.
 * There are 2 constructors (3 args and 4 args). The step method is defined as 
 * twirling to the right.
 * 
 * @author Ian Youn
 * @version 1.0
 * @since 11/17/2020
 */

import java.awt.Color;

public class TwirlingPig extends DancingPig
{
    /**
     * Creates a TwirlingPig object. This is a three-args constructor.
     * The parameters represent the x-coordinate, y-coordinate, and color of the 
     * TwirlingPig.
     * @param x     The x-coordinate of TwirlingPig's position.
     * @param y     The y-coordinate of TwirlingPig's position.
     * @param c     The color of TwirlingPig.
     */
    public TwirlingPig (int x, int y, Color c)
    {
        super(x, y, c);
    }

    
     /**
     * Creates a TwirlingPig object. This is a four-args constructor.
     * The parameters represent the x-coordinate, y-coordinate, color, and 
     * direction of the TwirlingPig.
     * @param x     The x-coordinate of TwirlingPig's position.
     * @param y     The y-coordinate of TwirlingPig's position.
     * @param c     The color of TwirlingPig.
     * @param p     The direction of the TwirlingPig.
     */
    public TwirlingPig (int x, int y, Color c, Point p)
    {
        super(x, y, c, p);
    }

    /**
     * Causes the TwirlingPig to perform one dance step.
     */
    public void step ( )
    {
        spinRight();
    }
}