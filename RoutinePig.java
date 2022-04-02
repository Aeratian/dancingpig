/**
 * RoutinePig.java
 * 
 * A class representing a pig that follows a routine as its dance.
 * Each RoutinePig has a has a position (x and y), a direction (Point), a Color,
 * a moveList, and an integer indicating which move the RoutinePig is on. 
 * There are 2 constructors (4 args and 5 args). Each step is part of the routine.
 * 
 * @author Ian Youn
 * @version 1.0
 * @since 11/17/2020
 */

import java.awt.Color;

public class RoutinePig extends DancingPig
{
    /** The array of moves in the RoutinePig's routine       */
    private PigConstants.DanceStep[] moveList;

    /** The move number the DancingPig is currently on */
    private int whichMove;

    /**
     * Creates a RoutinePig object. This is a four-args constructor.
     * The parameters represent the x-coordinate, y-coordinate, color,
     * and routine of the RoutinePig.
     * @param x         The x-coordinate of the RoutinePig.
     * @param y         The y-coordinate of the RoutinePig.
     * @param c         The color of the RoutinePig.
     * @param moves     The dance routine of the RoutinePig.
     */
    public RoutinePig (int x, int y, Color c, PigConstants.DanceStep [] moves)
    {
        super(x, y, c);
        moveList = moves;
    }

    /**
     * Creates a RoutinePig object. This is a five-args constructor.
     * The parameters represent the x-coordinate, y-coordinate, color,
     * direction, and routine of the RoutinePig.
     * @param x         The x-coordinate of the RoutinePig.
     * @param y         The y-coordinate of the RoutinePig.
     * @param c         The color of the RoutinePig.
     * @param p         The direction of the RoutinePig.
     * @param moves     The dance routine of the RoutinePig.
     */
    public RoutinePig (int x, int y, Color c, Point p, PigConstants.DanceStep [] moves)
    {
        super(x, y, c, p);
        moveList = moves;
    }

    /**
     * Causes the RoutinePig to perform one dance step.
     */
    public void step ( )
    {
        PigConstants.DanceStep curMove = moveList[whichMove %= moveList.length];
        switch(curMove)
        {
            case FORWARD: moveForward(64);          break;
            case BACKWARD: moveForward(-64);        break;
            case RIGHT: moveSide(64);               break;
            case LEFT: moveSide(-64);               break;
            case TURN_RIGHT: spinRight();           break;
            case TURN_LEFT: spinLeft();             break;
            case PAUSE:                             break;
        }
        whichMove++;
    }

    /**
     * Gets the last DanceStep the RoutinePig has performed.
     * @return      The last DanceStep of the RoutinePig.
     */
    public PigConstants.DanceStep getLastMove ()
    {
        return moveList[whichMove-1];
    }
    
}
