package abl.actions;

import game.Bot;
import game.GameEngine;

import java.awt.Point;
/**
 * Fires a bullet. 
 * 
 * @author Ben Weber 3-7-11
 */
public class ResetGun extends BaseAction {

	/**
	 * Fires a bullet at the target location.
	 * 
	 * Args:
	 *  - 0: bot id
	 *  - 1: boolean new hasFired value
	 */
	public void execute(Object[] args) {
		for(Bot b:GameEngine.getInstance().getBots()) {
			if(!(boolean)args[1] || b.getId() == (Integer)args[0]) {
				b.setHasFired((boolean)args[1]);
			}
		}
	}
}
