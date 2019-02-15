package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Point;
/**
 * Fires a bullet. 
 * 
 * @author Ben Weber 3-7-11
 */
public class Fire extends BaseAction {

	/**
	 * Fires a bullet at the target location.
	 * 
	 * Args:
	 *  - 0: source x position
	 *  - 1: source y position
	 *  - 2: target x position
	 *  - 3: target y position
	 */
	public void execute(Object[] args) {
		int closestX = (Integer) args[2];
		int closestY = (Integer) args[3];
		
		int botX = (Integer) args[0];
		int botY = (Integer) args[1];
		
		int id = 0;
		
		/* find this bot */
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getX() == botX && b.getY() == botY) {
				id = b.getId();
			}			
		}
			
		double closestDistance = Math.pow(botY - closestY, 2) + Math.pow(botX - closestX, 2);
		
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
		
		GameEngine.getInstance().fireBullet(
				new Point((Integer)args[0], (Integer)args[1]), 
				new Point(closestX, closestY));
	}
}
