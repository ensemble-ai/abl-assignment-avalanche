package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Point;
import java.awt.Color;
/**
 * Moves the chaser. 
 * 
 */
public class MoveTo extends BaseAction {

	/**
	 * Sets the trajectory of the player to move.
	 * Args:
	 *  - 0: xplayer
	 *  - 1: yplayer
	 *  - 2: d
	 *  - 3: bot id
	 */
	public void execute(Object[] args) {
		int id = (Integer) args[3];
		int x = 0, y = 0;
		int d = (Integer) args[2];
		int playerX = (Integer) args[0];
		int playerY = (Integer) args[1];
		if(id==0) {
			x = -1;
			y = -1;
		}
		if(id==1) {
			x = -1;
			y = 1;
		}
		if(id==2) {
			x = 1;
			y = -1;
		}
		if(id==3) {
			x = 1;
			y = 1;
		}
		
		int closestX = playerX;
		int closestY = playerY;
		
		int botX = 0;
		int botY = 0;
		
		/* find this bot */
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == id) {
				botX = b.getX();
				botY = b.getY();
			}			
		}
			
		double closestDistance = Math.pow(botY - playerY, 2) + Math.pow(botX - playerX, 2);
		
		/* find a stigmatized bot if its closer */
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() != id && b.getColor().getBlue() > 75) {
				double distance = Math.pow(b.getX() - botX, 2) + Math.pow(b.getY() - botY, 2);
				if(distance < closestDistance) {
					closestDistance = distance;
					closestX = b.getX();
					closestY = b.getY();
				}
			}
		}
			
			
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == id) {
				if(Math.abs(b.getLocation().x - (Integer)args[0]) < 10 && Math.abs(b.getLocation().y - (Integer)args[1]) < 10) {
					b.setColor(new Color(Math.max(b.getColor().getRed()-25, 0), 0, Math.min(b.getColor().getBlue()+25, 255)));
				}
				if(b.getColor().getBlue() > 75) {
					d = 500;
					b.setIsFiring(false);
				}
				if(b.getColor().getBlue() > 225) {
					closestX = playerX;
					closestY = playerY;
					d = 5 + (int) Math.round(20.0*Math.random());
				}
				b.move(new Point(closestX + (x * d), closestY + (y * d)));
			}
		}
	}
}
