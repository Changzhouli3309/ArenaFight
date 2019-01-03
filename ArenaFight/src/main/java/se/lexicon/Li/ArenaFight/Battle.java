package se.lexicon.Li.ArenaFight;

/*Battle –for the battle itself,
 * should contain the log of the battle, 
 * as well as references to both the player and the opponent */
public class Battle {
	
	/**
	 * Message tell the result of fight
	 * @param s1 :Power of fighter 1
	 * @param s2 :Power of fighter 2
	 * @param r : Number of Rounds
	 * @param p1 :Name of fighter 1
	 * @param p2 :Name of fighter 2
	 * @return String
	 */
	public String fightLog(int s1, int s2,int r, String p1,String p2) {
		if(s1==s2) {
			return "Round "+r+": Draw";
		}else {
			return "Round "+r+": "+p1+" Power:"+s1+", "+p2+" Power:"+s2+"\n "+
					getWin(s1, s2, p1, p2)+" Win!";
		}
	}
	
	/**
	 * Get name of the winner of fight
	 * @param s1 :Power of fighter 1
	 * @param s2 :Power of fighter 2
	 * @param p1 :Name of fighter 1
	 * @param p2 :Name of fighter 2
	 * @return Name of winner
	 */
	public String getWin(int s1, int s2, String p1,String p2) {
		if(s1==s2) {
			return "Not vaild name";
			
		}else if(s1>s2) {
			return p1;
		}else {
			return p2;
		}
	}
	
	/**
	 * Count number of damage for fighter
	 * @param p :Name of fighter
	 * @param win :Name of winner
	 * @return number of damage
	 */
	public int battleRes(String p, String win) {
		if (win.equals("Not vaild name")) {
			return 0;
		}else if(p.equals(win)){
			return 0;
		}else {
			return -1;
		}
	}
	
}
