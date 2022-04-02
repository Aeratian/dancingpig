/**
 * DanceFloor3.java
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
 * @since 11/15/2020
 */

import java.awt.Color;
import java.awt.Font;

public class DanceFloor3
{ 
	/**  An array that stores all of the DancingPig variants.               */
	private DancingPig [] pig;
	
	/** 
	 *  Creates a DanceFloor object.  A no-args constructor.  
	 *  Sets up the size of the DancingPig array.
	 */
	public DanceFloor3 ( )
	{
		pig = new DancingPig[50];
	}

	/**
	 *  The main method, to create an instance of the DanceFloor.  The canvas
	 *  is set up, and the GUI runs.
	 */
	public static void main(String[] args)
	{
		DanceFloor3 dance = new DanceFloor3();
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
		int counter = 0;
		int rememberThisOne = -1;
		addPigs();
		while(partyOn)
		{
			StdDraw.clear(new Color(0,0,95));
			drawPigs();
			StdDraw.show();
			StdDraw.pause(PigConstants.DRAW_DELAY);
			allPigsTakeNextDanceStep();
			counter++;
			if(counter == 17)
			{
				counter = 0;
				if(rememberThisOne != -1)
				{
					((RoutineLeaderPig)pig[4]).addFollower(pig[rememberThisOne]);
				}
				rememberThisOne = (int)(Math.random() * (18 - 5 + 1) + 5);
				((RoutineLeaderPig)pig[4]).removeFollower(pig[rememberThisOne]);
			}
		}
	}
	
	/** 
	 *  Adds DancingPigs to the array.
	 */
	public void addPigs ( )
	{
		pig[0] = new TravelingPig(40, 40, Color.RED, PigConstants.EAST);
		pig[1] = new FollowingPig((Leader)pig[0], Color.WHITE);
		pig[2] = new TravelingPig(1160, 760, Color.RED, PigConstants.WEST);
		pig[3] = new FollowingPig((Leader)pig[2], Color.WHITE);
		pig[4] = new RoutineLeaderPig(600, 400, Color.RED, PigConstants.NORTH, new PigConstants.DanceStep[]{PigConstants.DanceStep.LEFT, PigConstants.DanceStep.FORWARD, 
			PigConstants.DanceStep.TURN_RIGHT, PigConstants.DanceStep.FORWARD, PigConstants.DanceStep.TURN_LEFT, PigConstants.DanceStep.TURN_LEFT, PigConstants.DanceStep.PAUSE,
			PigConstants.DanceStep.BACKWARD, PigConstants.DanceStep.TURN_RIGHT, PigConstants.DanceStep.BACKWARD, PigConstants.DanceStep.BACKWARD, PigConstants.DanceStep.LEFT,
			PigConstants.DanceStep.LEFT, PigConstants.DanceStep.FORWARD, PigConstants.DanceStep.RIGHT, PigConstants.DanceStep.PAUSE, PigConstants.DanceStep.PAUSE});
		pig[5] = new FollowingPig((Leader)pig[4], 600, 560, Color.WHITE, PigConstants.NORTH);
		pig[6] = new FollowingPig((Leader)pig[4], 760, 560, Color.WHITE, PigConstants.NORTH);
		pig[7] = new FollowingPig((Leader)pig[4], 760, 400, Color.WHITE, PigConstants.NORTH);
		pig[8] = new FollowingPig((Leader)pig[4], 760, 240, Color.WHITE, PigConstants.NORTH);
		pig[9] = new FollowingPig((Leader)pig[4], 600, 240, Color.WHITE, PigConstants.NORTH);
		pig[10] = new FollowingPig((Leader)pig[4], 440, 240, Color.WHITE, PigConstants.NORTH);
		pig[11] = new FollowingPig((Leader)pig[4], 440, 400, Color.WHITE, PigConstants.NORTH);
		pig[12] = new FollowingPig((Leader)pig[4], 440, 560, Color.WHITE, PigConstants.NORTH);
		pig[13] = new FollowingPig((Leader)pig[4], 920, 240, Color.WHITE, PigConstants.NORTH);
		pig[14] = new FollowingPig((Leader)pig[4], 920, 400, Color.WHITE, PigConstants.NORTH);
		pig[15] = new FollowingPig((Leader)pig[4], 920, 560, Color.WHITE, PigConstants.NORTH);
		pig[16] = new FollowingPig((Leader)pig[4], 280, 240, Color.WHITE, PigConstants.NORTH);
		pig[17] = new FollowingPig((Leader)pig[4], 280, 400, Color.WHITE, PigConstants.NORTH);
		pig[18] = new FollowingPig((Leader)pig[4], 280, 560, Color.WHITE, PigConstants.NORTH);
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
