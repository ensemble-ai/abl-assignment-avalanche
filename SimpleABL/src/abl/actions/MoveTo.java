package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Point;
/**
 * Moves the chaser. 
 * 
 */
public class MoveTo extends BaseAction {

	/**
	 * Sets the trajectory of the player to move.
	 * Args:
	 *  - 0: xdir
	 *  - 1: ydir
	 *  - 2: bot id
	 */
	public void execute(Object[] args) {
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == (Integer)args[2]) {
				b.move(new Point((Integer) args[0], (Integer)args[1]));
			}
		}
	}
}
