/**
 * DancingPig.java
 * 
 * An abstract DancingPig.  Contains the basic move methods for a 
 * DancingPig.  This class is to be extended, so that the methods 
 * can be used.  Each DancingPig has a position (x and y), a direction
 * (a Point), and a Color.  There are 2 constructors (3 args and 4 args).
 * A DancingPig can spinRight, spinLeft, moveForward (and backward),
 * moveSide (left or right), and be drawn.  The abstract method step will
 * need to be defined by subclasses of the DancingPig.
 *
 * @author Scott DeRuiter and Ian Youn
 * @version 1.0
 * @since 11/12/2020
 */

import java.awt.Color;

public abstract class DancingPig
{
	private Point direction;
	private int x;
	private int y;
	private Color color;

	/**
	 * Creates a new DancingPig at the given location with the given color. DancingPig defaults to facing SOUTH.
	 * @param x the DancingPig's x location
	 * @param y the DancingPig's y location
	 * @param color the DancingPig's color
	 */
	public DancingPig(int x, int y, Color color)
	{
		this.x = x;
		this.y = y;
		this.direction = PigConstants.SOUTH;
		this.color = color;
	}

	/**
	 * Creates a new DancingPig at the given location, with the given color, facing in the given direction.
	 * @param x the DancingPig's x location
	 * @param y the DancingPig's y location
	 * @param color the DancingPig's color
	 * @param direction the DancingPig's direction
	 */
	public DancingPig(int x, int y, Color color, Point p)
	{
		this.x = x;
		this.y = y;
		this.direction = p;
		this.color = color;
	}

	/**
	 * An abstract method (that must be overridden in a subclass) that causes the DancingPig to perform a single dance step.
	 * The details of what that step is should be defined by the concrete child class.
	 */
	public abstract void step();

	/**
	 * A method that spins the DancingPig 90 degrees to the right (clockwise) 
	 * @return whether or not the DancingPig successfully turned.
	 */
	public boolean spinRight()
	{
		if(this.direction == PigConstants.NORTH)
		{
			this.direction = PigConstants.EAST;
		}
		else if(this.direction == PigConstants.EAST)
		{
			this.direction = PigConstants.SOUTH;
		}
		else if(this.direction == PigConstants.SOUTH)
		{
			this.direction = PigConstants.WEST;
		}
		else if(this.direction == PigConstants.WEST)
		{
			this.direction = PigConstants.NORTH;
		}

		return true;
	}

	/**
	 * A method that spins the DancingPig 90 degrees to the left (counter-clockwise) 
	 * @return whether or not the DancingPig successfully turned.
	 */
	public boolean spinLeft()
	{
		if(this.direction == PigConstants.NORTH)
		{
			this.direction = PigConstants.WEST;
		}
		else if(this.direction == PigConstants.EAST)
		{
			this.direction = PigConstants.NORTH;
		}
		else if(this.direction == PigConstants.SOUTH)
		{
			this.direction = PigConstants.EAST;
		}
		else if(this.direction == PigConstants.WEST)
		{
			this.direction = PigConstants.SOUTH;
		}

		return true;
	}

	/**
	 * Moves the DancingPig along the line it is facing. Note that the DancingPig can move backwards.
	 * The DancingPig will only move if it stays within the bounds of the dance floor.
	 * @param dist the number of pixels the DancingPig should move. A negative number causes the DancingPig to step backwards.
	 * @return whether or not the DancingPig successfully moved.
	 */
	public boolean moveForward(int dist)
	{
		int newX = x + dist * this.direction.getX();
		int newY = y + dist * this.direction.getY();
		
		if(newX >= 0 && newX <= PigConstants.SCREEN_WIDTH && newY >= 0 && newY <= PigConstants.SCREEN_HEIGHT)
		{
			x = newX;
			y = newY;
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Moves the DancingPig sideways relative to its facing direction.  A positive parameter means it moves to the right, 
	 * a negative parameter means it moves to the left.
	 * The DancingPig will only move if it stays within the bounds of the dance floor.
	 * @param dist the number of pixels the DancingPig should move. A negative number causes the DancingPig to move right, a negative to move left.
	 * @return whether or not the DancingPig successfully moved.
	 */
	public boolean moveSide(int dist)
	{
		int newX = x + dist * this.direction.getY();
		int newY = y - dist * this.direction.getX();
		
		if(newX >= 0 && newX <= PigConstants.SCREEN_WIDTH && newY >= 0 && newY <= PigConstants.SCREEN_HEIGHT)
		{
			x = newX;
			y = newY;
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Draws the DancingPig, with correct position, orientation (direction), and color.
	 */
	public void draw ( )
	{
		StdDraw.setPenColor(color); 
		StdDraw.filledCircle(x, y, 32);
		if(this.direction == PigConstants.NORTH)
		{
			StdDraw.picture(x, y, "dancingpig.png", 180);
		}
		else if(this.direction == PigConstants.WEST)
		{
			StdDraw.picture(x, y, "dancingpig.png", 270);
		}
		else if(this.direction == PigConstants.SOUTH)
		{
			StdDraw.picture(x, y, "dancingpig.png", 0);
		}
		else if(this.direction == PigConstants.EAST)
		{
			StdDraw.picture(x, y, "dancingpig.png", 90);
		}
	}

	/**
	 * Gets the direction of the current DancingPig object.
	 */
	public Point getDirection ( )
	{
		return direction;
	}

	/**
	 * Gets the x-coordinate of the current DancingPig's position
	 */
	public int getX ( )
	{
		return x;
	}

	/**
	 * Gets the y-coordinate of the current DancingPig's position
	 */
	public int getY ( )
	{
		return y;
	}

	/**
	 * Gets the color of the current DancingPig
	 */
	public Color getColor ( )
	{
		return color;
	}

	/**
	 * Sets the color of the current DancingPig
	 * @param c		The color to be set
	 */
	public void setColor(Color c)
	{
		color = c;
	}
}
