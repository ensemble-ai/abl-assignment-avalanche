package abl.actions;

import abl.runtime.BehavingEntity;
import abl.wmes.BotWME;
import game.Bot;
import game.GameEngine;

/**
 * Makes a new bot.
 * 
 */
public class MakeBot extends BaseAction {

	/**
	 * Sets the trajectory of the player to move.
	 * Args:
	 *  - 0: bot id
	 */
	public void execute(Object[] args) {
		System.out.println("Making bot!");
		GameEngine.getInstance().makeBot();
	}
}
