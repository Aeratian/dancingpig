/**
 * FollowingPig.java
 * 
 * A class representing a pig that follows a Leader. Each FollowingPig has a
 * position (x and y),  a direction (Point), a Color, and a Leader. There are 
 * 2 constructors (2 args and 5 args). Each step is defined by its leader.
 * 
 * @author Ian Youn
 * @version 1.0
 * @since 11/20/2020
 */

import java.awt.Font;
import java.awt.Color;

public class FollowingPig extends DancingPig
{
    /** The leader of the FollowingPig */
    private Leader leader;

    /**
     * Creates a FollowingPig object. This is a two-args constructor.
     * The parameters represent the leader and the color of the FollowingPig.
     * @param l     The leader of the FollowingPig.
     * @param c     The color of the FollowingPig.
     */
    public FollowingPig (Leader l, Color c)
    {
        super(l.getLocation().getX(), l.getLocation().getY(), c, l.getDirection());
        leader = l;
        moveForward(64);
        spinLeft();
        spinLeft();
        leader.addFollower(this);
    }

    /**
     * Creates a FollowingPig object. This is a five-args constructor.
     * The parameters represent the leader, the x-coordinate, the 
     * y-coordinate, the color, and the direction of the FollowingPig.
     * @param l     The leader of the FollowingPig.
     * @param x     The x-coordinate of the FollowingPig.
     * @param y     The y-coordinate of the FollowingPig.
     * @param c     The color of the FollowingPig.
     * @param p     The direction of the FollowingPig.
     */
    public FollowingPig (Leader l, int x, int y, Color c, Point p)
    {
        super(x, y, c, p);
        leader = l;
        leader.addFollower(this);
    }

    /**
     * Overrides the abstract step method in the DancingPig class.
     * Is empty because the steps are done by the Leader.
     */
    public void step ( )
    {

    }

    /**
     * Overrides the draw method so a "F" is printed 
     * on the FollowingPig.
     */
    public void draw ( )
    {
        super.draw();
        Font font = new Font("Arial", Font.BOLD, 30);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setFont(font);
        StdDraw.text(getX(), getY(), "F");
    }
}
