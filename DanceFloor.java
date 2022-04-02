/**
 * DanceFloor.java
 * 
 * A "dance floor", where we can test the different types of
 * DancingPigs that have been created.  The dance floor uses the
 * dimensions found in the PigConstants file, to set up a 
 * screen width and height.  An array of 50 DancingPigs is
 * created, and the Pigs are instantiated and added to this array.
 * An endless loop is created, so that the Pigs can dance without
 * ceasing.
 *
 * @author Scott DeRuiter
 * @version 1.0
 * @since 11/12/2020
 */

import java.awt.Color;
import java.awt.Font;

public class DanceFloor 
{ 
	/**  An array that stores all of the DancingPig variants.               */
	private DancingPig [] pig;
	
	/** 
	 *  Creates a DanceFloor object.  A no-args constructor.  
	 *  Sets up the size of the DancingPig array.
	 */
	public DanceFloor ( )
	{
		pig = new DancingPig[50];
	}

	/**
	 *  The main method, to create an instance of the DanceFloor.  The canvas
	 *  is set up, and the GUI runs.
	 */
	public static void main(String[] args)
	{
		DanceFloor dance = new DanceFloor();
		dance.setUpCanvas();
		dance.runGUI();
	}
	
	/** 
	 *  Sets up the canvas, using methods from StdDraw.  This includes
	 *  setting up the canvas size, the horizontal scale (Xscale), and
	 *  the vertical scale (Yscale).  Double buffering is enabled, so that
	 *  the animation will run smoothly.
	 */
	public void setUpCanvas ( )
	{
		StdDraw.setCanvasSize(PigConstants.SCREEN_WIDTH, PigConstants.SCREEN_HEIGHT);
		StdDraw.setXscale(0, PigConstants.SCREEN_WIDTH);
		StdDraw.setYscale(0, PigConstants.SCREEN_HEIGHT);

		StdDraw.enableDoubleBuffering();
	}
	
	/** 
	 *  Runs the Graphical User Interface.  Pigs are added, and the loop runs without
	 *  stopping.  With each iteration of the loop the Pigs are drawn, and then
	 *  the next dance step is taken by all Pigs on the DanceFloor.
	 */
	public void runGUI ( )
	{
		boolean partyOn = true;
		addPigs();
		while(partyOn)
		{
			StdDraw.clear(new Color(0,0,95));
			drawPigs();
			StdDraw.show();
			StdDraw.pause(PigConstants.DRAW_DELAY);
			allPigsTakeNextDanceStep();
		}
	}
	
	/** 
	 *  Adds DancingPigs to the array.
	 */
	public void addPigs ( )
	{
		pig[0] = new TwirlingPig(920, 760, Color.BLUE);
		pig[1] = new TwirlingPig(1000, 760, Color.GREEN, PigConstants.WEST);
		pig[2] = new TwirlingPig(1080, 760, Color.GRAY, PigConstants.NORTH);
		pig[3] = new TwirlingPig(1160, 760, Color.ORANGE, PigConstants.EAST);
		pig[4] = new ForwardAndBackPig(840, 760, Color.CYAN);
		pig[5] = new ForwardAndBackPig(760, 760, Color.RED, PigConstants.WEST);
		pig[6] = new SideToSidePig(680, 760, Color.MAGENTA);
		pig[7] = new SideToSidePig(520, 760, Color.WHITE, PigConstants.EAST);
		pig[8] = new RoutinePig(1160, 40, Color.RED, PigConstants.WEST, new PigConstants.DanceStep[]{PigConstants.DanceStep.LEFT, PigConstants.DanceStep.TURN_LEFT, 
			PigConstants.DanceStep.LEFT, PigConstants.DanceStep.BACKWARD, PigConstants.DanceStep.TURN_RIGHT, PigConstants.DanceStep.FORWARD, PigConstants.DanceStep.PAUSE});
		pig[9] = new RoutinePig(1000, 40, Color.YELLOW, PigConstants.NORTH, new PigConstants.DanceStep[]{PigConstants.DanceStep.FORWARD, PigConstants.DanceStep.TURN_LEFT, 
			PigConstants.DanceStep.FORWARD, PigConstants.DanceStep.RIGHT, PigConstants.DanceStep.TURN_RIGHT, PigConstants.DanceStep.LEFT, PigConstants.DanceStep.BACKWARD, 
			PigConstants.DanceStep.BACKWARD, PigConstants.DanceStep.RIGHT, PigConstants.DanceStep.PAUSE, PigConstants.DanceStep.RIGHT, PigConstants.DanceStep.PAUSE, PigConstants.DanceStep.PAUSE});
	}
	
	/** 
	 *  Draws DancingPigs on the DanceFloor.
	 */
	public void drawPigs ( )
	{			
		for(int i = 0; i < pig.length; i++)
		{
			if(pig[i] != null)
			{
				pig[i].draw();
			}
		}
	}
	
	/** 
	 *  All of the DancingPigs in the array take the next dance step.
	 */
	public void allPigsTakeNextDanceStep ( )
	{			
		for(int i = 0; i < pig.length; i++)
		{
			if(pig[i] != null)
			{
				pig[i].step();
			}
		}
	}
}
