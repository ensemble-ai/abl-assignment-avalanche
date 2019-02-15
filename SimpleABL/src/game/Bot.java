package game;

import java.awt.Color;
import java.awt.Point;

public class Bot {
 
	public static final int Size = 10;
	
	static int IdCount = 0;
	
	/** Location of the bot */
	private Point location;
	
	/** Trajectory of the bot */
	private Point trajectory;
	
	/** unique bot ID */
	private int id;

	/** color of the bot */
	private Color color;

	/** if the bot has fired recently */
	private boolean hasFired = false;
	
	/** if the bot is firing */
	private boolean isFiring = true;

	private boolean hasMoved = false;
		
	private int size = Size;
	
	public Bot() {
		this.location = new Point(0,0);
		this.trajectory = new Point(0,0);
		this.id = IdCount++;
		this.color = new Color(255, 0, 0);
		this.hasFired = false;
		this.isFiring = true;
		this.hasMoved = false;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public Point getTrajectory() {
		return trajectory;
	}

	public void setTrajectory(Point trajectory) {
		this.trajectory = trajectory;
	}
	
	public int getX( ) {
		return this.location.x;
	}
	
	public int getY( ) {
		return this.location.y;
	}
	
	public int getId() {
		return id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void move(Point destination){
		double dx = destination.x - location.x;
		double dy = destination.y - location.y;
		double magnitude = Math.sqrt(dx*dx + dy*dy);
		dx = GameEngine.BotSpeed*dx/magnitude;
		dy = GameEngine.BotSpeed*dy/magnitude;
		this.setTrajectory(new Point((int) dx, (int) dy));
	}
	
	public boolean getHasFired() {
		return this.hasFired;
	}
	
	public void setHasFired(boolean hasFired) {
		this.hasFired =  hasFired;
	}
	
	public boolean getIsFiring() {
		return this.isFiring;
	}
	
	public void setIsFiring(boolean isFiring) {
		this.isFiring = isFiring;
	}
	
	public boolean getHasMoved() {
		return this.hasMoved;
	}
	
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
}
