package abl.wmes;

import java.awt.Point;
import java.awt.Color;

import wm.WME;
/**
 * Stores information about the bot.
 * 
 * @author Ben Weber 3-7-11
 * @author Josh McCoy 1-23-2019
 */
public class BotWME extends WME {

	/** Location of the bot */
	private Point location;
	
	/** Trajectory of the bot */
	private Point trajectory;
	
	/** ID of the bot */
	private int id;
	
	/** Color of the bot */
	private Color color;
	
	/** if the bot has fired recently */
	private boolean hasFired;
		
	/**
	 * Instantiates a working memory element for tracking a bot.
	 */
	public BotWME(Point location, Point trajectory, int id, Color color, boolean hasFired) {
		this.location = location;
		this.trajectory = trajectory;
		this.id = id;
		this.color = color;
		this.hasFired = hasFired;
	}
	
	/**
	 * Returns the x location of the bot. 
	 */
	public int getLocationX() {
		return location.x;
	}
	
	/**
	 * Returns the y location of the bot. 
	 */
	public int getLocationY() {
		return location.y;
	}
	
	/**
	 * Returns the x direction of the bot. 
	 */
	public int getTrajectoryX() {
		return trajectory.x;
	}
	
	/**
	 * Returns the y direction of the bot. 
	 */
	public int getTrajectoryY() {
		return trajectory.y;
	}

	/**
	 * Returns the color of the bot.
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Returns the red color value of the bot.
	 */
	public int getColorR() {
		return color.getRed();
	}
	
	/**
	 * Returns the green color value of the bot.
	 */
	public int getColorG() {
		return color.getGreen();
	}
	
	/**
	 * Returns the blue color value of the bot.
	 */
	public int getColorB() {
		return color.getBlue();
	}

	public boolean getHasFired() {
		return hasFired;
	}
	
	public int getId() {
		return id;
	}
		
	public void setId(int id) {
		this.id = id;
	}
}
