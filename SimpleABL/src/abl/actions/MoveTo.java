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
	 *  - 0: xplayer
	 *  - 1: yplayer
	 *  - 2: d
	 *  - 3: bot id
	 */
	public void execute(Object[] args) {
		int id = (Integer) args[3];
		int x = 0, y = 0;
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
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == id) {
				b.move(new Point((Integer) args[0] + (x * (Integer) args[2]), (Integer)args[1] + (y * (Integer)args[2])));
			}
		}
	}
}
