package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Color;
/**
 * Colors the chaser. 
 * 
 */
public class SetColor extends BaseAction {

	/**
	 * Sets the trajectory of the player to move.
	 * Args:
	 *  - 0: red
	 *  - 1: blue
	 *  - 2: green
	 *  - 3: bot id
	 */
	public void execute(Object[] args) {
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(b.getId() == (Integer)args[3]) {
				b.setColor(new Color((Integer)args[0], (Integer)args[1], (Integer)args[2]));
			}
		}
	}
}
