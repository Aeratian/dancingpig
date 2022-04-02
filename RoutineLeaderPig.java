/**
 * RoutineLeaderPig.java
 * 
 * A class representing a pig that leads and follows a routine as its dance.
 * Each RoutineLeaderPig has a has a position (x and y), a direction (Point), 
 * a Color, a moveList, an integer indicating which move the RoutineLeaderPig is on, 
 * an array of followers, and a follower count.  There are 2 constructors 
 * (4 args and 5 args). Each step is a step of the routine.
 * 
 * @author Ian Youn
 * @version 1.0
 * @since 11/20/2020
 */

import java.awt.Color;
import java.awt.Font;

public class RoutineLeaderPig extends RoutinePig implements Leader
{
    /** The array of followers of the RoutineLeaderPig */
    private DancingPig [] followers;

    /** The amount of followers the RoutineLeaderPig has */
    private int followerCount;

    /**
     * Creates a RoutineLeaderPig object. This is a four-args constructor.
     * The parameters represent the x-coordinate, y-coordinate, color,
     * and routine of the RoutineLeaderPig.
     * @param x         The x-coordinate of the RoutineLeaderPig.
     * @param y         The y-coordinate of the RoutineLeaderPig.
     * @param c         The color of the RoutineLeaderPig.
     * @param moves     The dance routine of the RoutineLeaderPig.
     */
    public RoutineLeaderPig (int x, int y, Color c, PigConstants.DanceStep [] moves)
    {
        super(x, y, c, moves);
        followers = new DancingPig [20];
    }

     /**
     * Creates a RoutineLeaderPig object. This is a five-args constructor.
     * The parameters represent the x-coordinate, y-coordinate, color,
     * direction, and routine of the RoutineLeaderPig.
     * @param x         The x-coordinate of the RoutineLeaderPig.
     * @param y         The y-coordinate of the RoutineLeaderPig.
     * @param c         The color of the RoutineLeaderPig.
     * @param p         The direction of the RoutineLeaderPig.
     * @param moves     The dance routine of the RoutineLeaderPig.
     */
    public RoutineLeaderPig (int x, int y, Color c, Point p, PigConstants.DanceStep [] moves)
    {
        super(x, y, c, p, moves);
        followers = new DancingPig [20];
    }
 
    /**
     * Gets the current location of the RoutineLeaderPig
     * @return      The current location of the RoutineLeaderPig
     */
    public Point getLocation ( )
    {
        return new Point(getX(), getY());
    }

    /**
     * Gets the current direction of the RoutineLeaderPig
     * @return      The current direction of the RoutineLeaderPig
     */
    public Point getDirection ( )
    {
        return super.getDirection();
    }

    /**
     * Adds a follower to the RoutineLeaderPig
     */
    public void addFollower (DancingPig pig)
    {
        followers[followerCount] = pig;
        followerCount++;
    }

    /**
     * Removes a follower from the Traveling Pig.
     */
    public void removeFollower (DancingPig pig)
    {
        boolean pigFound = false;
        for(int i=0; i<followerCount; i++)
        { 
            if(followers[i].equals(pig))
            {
                pigFound = true;

            }
            else if(pigFound)
            {
                followers[i-1] = followers[i];
                followers [i] = null;
            }
        }
        followerCount--;
    }

    /**
     * Causes the RoutineLeaderPig and each of its followers to perform one
     * dance step.
     */
    public void step( )
    {
        super.step();
        for(int i=0; i < followerCount; i++)
        {
            switch(getLastMove())
            {
                case FORWARD: followers[i].moveForward(64);         break;
                case BACKWARD: followers[i].moveForward(-64);       break;
                case RIGHT: followers[i].moveSide(64);              break;
                case LEFT: followers[i].moveSide(-64);              break;
                case TURN_RIGHT: followers[i].spinRight();          break;
                case TURN_LEFT: followers[i].spinLeft();            break;
                case PAUSE:                                         break;
            }
        }
    }

    /**
     * Overrides the draw method so a "L" is printed 
     * on the RoutineLeaderPig.
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
