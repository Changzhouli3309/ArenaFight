package se.lexicon.Li.ArenaFight;

/*Battle –for the battle itself,
 * should contain the log of the battle, 
 * as well as references to both the player and the opponent */
import se.lexicon.Li.ArenaFight.Fighter;

public class Battle {

	/**
	 * Message tell the result of fight
	 * 
	 * @param p1 :Class Fighter No.1
	 * @param p2 :Class Fighter 2
	 * @param r  : Number of Rounds
	 * @return String
	 */
	public String fightLog(Fighter p1, Fighter p2, int r) {
		if (p1.getPow() == p2.getPow()) {
			return "Round " + r + ": " + p1.getName() + " Power:" + p1.getPow() + ", " + p2.getName() + " Power:"
					+ p2.getPow() + "\nDraw!";
		} else {
			return "Round " + r + ": " + p1.getName() + " Power:" + p1.getPow() + ", " + p2.getName() + " Power:"
					+ p2.getPow() + "\n" + getWin(p1, p2) + " Win!";
		}
	}

	/**
	 * Get name of the winner of fight
	 * 
	 * @param p1 :Class Fighter 1
	 * @param p2 :Class Fighter 2
	 * @return Name of winner
	 */
	public String getWin(Fighter p1, Fighter p2) {
		if (p1.getPow() == p2.getPow()) {
			return "Not vaild name";

		} else if (p1.getPow() > p2.getPow()) {
			return p1.getName();
		} else {
			return p2.getName();
		}
	}

	/**
	 * Count number of damage for fighter
	 * 
	 * @param p   :Class Fighter
	 * @param win :Name of winner
	 * @return number of damage
	 */
	public int battleRes(Fighter p, String win) {
		if (win.equals("Not vaild name")) {
			return 0;
		} else if (p.getName().equals(win)) {
			return 0;
		} else {
			return -1;
		}
	}

}
