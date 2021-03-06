package se.lexicon.Li.ArenaFight;

/**
 * Round –one round of dice rolling, should correspond to a post in the battle
 * log
 * 
 */
public class Round {

	private int fightN = 1, roundN = 0;
	private String[] fullLog = new String[0];

	/**
	 * Rest the number of round and empty battle log
	 */
	public void restR() {
		roundN = 0;
		fullLog = new String[0];
	}

	/**
	 * Number of round plus 1
	 */
	public void goToNextRound() {
		roundN += 1;
	}

	/**
	 * Print the text once and save to log
	 * 
	 * @param s :Text to print and save
	 */
	public void saveLog(String s) {
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
			System.out.println("Battle log is empty\n");
		}
		for (String s : fullLog) {
			System.out.println(s + "\n");

		}
		System.out.println("-------------------------------\n");
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
