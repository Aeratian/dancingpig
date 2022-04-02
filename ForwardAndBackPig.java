/**
 * ForwardAndBackPig.java
 * 
 * A class representing a pig that moves forward and back as its
 * dance. Each ForwardAndBackPig has a position (x and y), a direction
 * (Point), a Color, and a boolean stating if the ForwardAndBackPig is
 * moving forwards or backwards. There are 2 constructors (3 args and 4 args).
 * The step method is defined as moving forwards or backwards 64 units based
 * on the whichStep boolean.
 * 
 * @author Ian Youn
 * @version 1.0
 * @since 11/17/2020
 */

import java.awt.Color;

public class ForwardAndBackPig extends DancingPig
{
    /** A boolean representing which step the ForwardAndBackPig is on.          */
    private boolean whichStep;

    /**
     * Creates a ForwardAndBackPig object. This is a three-args constructor.
     * The parameters represent the x-coordinate, y-coordinate, and color of the 
     * ForwardAndBackPig.
     * @param x     The x-coordinate of ForwardAndBackPig's position.
     * @param y     The y-coordinate of ForwardAndBackPig's position.
     * @param c     The color of ForwardAndBackPig.
     */
    public ForwardAndBackPig (int x, int y, Color c)
    {
        super(x, y, c);
    }

     /**
     * Creates a ForwardAndBackPig object. This is a four-args constructor.
     * The parameters represent the x-coordinate, y-coordinate, color, and 
     * direction of the ForwardAndBackPig.
     * @param x     The x-coordinate of ForwardAndBackPig's position.
     * @param y     The y-coordinate of ForwardAndBackPig's position.
     * @param c     The color of ForwardAndBackPig.
     * @param p     The direction of the ForwardAndBackPig.
     */
    public ForwardAndBackPig (int x, int y, Color c, Point p)
    {
        super(x, y, c, p);
    }

    /**
     * Causes the ForwardAndBackPig to perform one dance step.
     */
    public void step ( )
    {
        if(!whichStep)
            moveForward(64);
        else
            moveForward(-64);

        whichStep = !whichStep;
    }
}