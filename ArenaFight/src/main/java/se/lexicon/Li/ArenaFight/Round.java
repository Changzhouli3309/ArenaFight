package se.lexicon.Li.ArenaFight;

/**
 * Round –one round of dice rolling, should correspond to a post in the battle
 * log
 * 
 */
public class Round {

	private int fightN = 1, roundN = 1;
	private String[] fullLog = new String[0];

	/**
	 * Rest the number of round and empty battle log
	 */
	public void restR() {
		setRoundN(1);
		fullLog = new String[0];
	}

	/**
	 * Number of round plus 1
	 */
	public void goToNextRound() {
		setRoundN(getRoundN() + 1);
	}

	/**
	 * Print the text once and save to log
	 * 
	 * @param s :Text to print and save
	 */
	public void saveLog(String s) {
		System.out.println(s);
		fullLog = FixArr.addToArr(fullLog, s);
	}

	/**
	 * Random number between 1 to 6
	 * 
	 * @return 1-6
	 */
	public int rollDice() {
		return FixInt.randomInt(6, 1);
	}

	/**
	 * print out the battle log
	 */
	public void printFullLog() {
		System.out.println("Battle log:-------------------");
		if (fullLog.equals(null)) {
			System.out.println("Battle log is empty");
			System.out.println();
		}
		for (String s : fullLog) {
			System.out.println(s);
			System.out.println();
		}
		System.out.println("-------------------------------");
		System.out.println();
	}

	public int getRoundN() {
		return roundN;
	}

	public void setRoundN(int roundN) {
		this.roundN = roundN;
	}

	public int getFightN() {
		return fightN;
	}

	public void setFightN(int fightN) {
		this.fightN = fightN;
	}
}
