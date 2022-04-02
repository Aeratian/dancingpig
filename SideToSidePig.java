/**
 * SideToSidePig.java
 * 
 * A class representing a pig that moves side to side as its
 * dance. Each SideToSidePig has a position (x and y), a direction
 * (Point), a Color, and a boolean stating if the SideToSidePig is
 * moving left or right. There are 2 constructors (3 args and 4 args).
 * The step method is defined as moving left or right 64 units based
 * on the whichStep boolean.
 * 
 * @author Ian Youn
 * @version 1.0
 * @since 11/17/2020
 */

import java.awt.Color;

public class SideToSidePig extends DancingPig
{
    /** A boolean representing which step the SideToSidePig is on.          */
    private boolean whichStep;
    
    /**
     * Creates a SideToSidePig object. This is a three-args constructor.
     * The parameters represent the x-coordinate, y-coordinate, and color of the 
     * SideToSidePig.
     * @param x     The x-coordinate of SideToSidePig's position.
     * @param y     The y-coordinate of SideToSidePig's position.
     * @param c     The color of SideToSidePig.
     */
    public SideToSidePig (int x, int y, Color c)
    {
        super(x, y, c);
    }

    /**
     * Creates a SideToSidePig object. This is a four-args constructor.
     * The parameters represent the x-coordinate, y-coordinate, color, and 
     * direction of the SideToSidePig.
     * @param x     The x-coordinate of SideToSidePig's position.
     * @param y     The y-coordinate of SideToSidePig's position.
     * @param c     The color of SideToSidePig.
     * @param p     The direction of the SideToSidePig.
     */
    public SideToSidePig (int x, int y, Color c, Point p)
    {
        super(x, y, c, p);
    }

    /**
     * Causes the SideToSidePig to perform one dance step.
     */
    public void step ( )
    {
        if(!whichStep)
            moveSide(64);
        else
            moveSide(-64);

        whichStep = !whichStep;
    }
}
