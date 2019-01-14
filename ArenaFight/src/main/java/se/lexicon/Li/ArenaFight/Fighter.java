package se.lexicon.Li.ArenaFight;

public class Fighter {
	private String name;
	private int hp, pow, balance = 0;
	private boolean alive = true, powP = false, defP = false;
	private String[] pLog = new String[0];

	/**
	 * Massage tells names of fighters and number of fight
	 * 
	 * @param name1  :Name of fighter 1
	 * @param name2  :Name of fighter 2
	 * @param fightN Number of fight
	 * @return String
	 */
	public String infFighter(String name1, String name2, int fightN) {
		return "Fight No." + fightN + ": " + name1 + " vs " + name2;
	}

	/**
	 * Massage tells number of round and winner of fight
	 * 
	 * @param rN  :Number of round
	 * @param win :winner of fight
	 * @return String
	 */
	public String infRes(int rN, String win) {
		return "At round " + rN + ", " + win + " win.";
	}

	/**
	 * Save text to battle log of player
	 * 
	 * @param s :Text to save
	 */
	public void savepLog(String s) {
		pLog = FixArr.addToArr(pLog, s);
	}

	public void printlog() {
		System.out.println("---------------------------------");
		System.out.println("Fighter " + name + "´s record:\n");
		for (String s : pLog) {
			System.out.println(s);
		}
		if (alive) {

			System.out.println("---------------------------------");
		} else {
			System.out.println("Fighter " + name + " is retired.");
			System.out.println("End------------------------------");
		}

	}

	/**
	 * Get a random String from a String arrays
	 * 
	 * @param s :String arrays
	 * @return
	 */
	public String getRName(String[] s) {
		return s[FixInt.randomInt(s.length, 0)];
	}

	/**
	 * Check the hp for fighter.
	 */
	public void stillAlive() {
		if (getHp() <= 0) {
			setAlive(false);
		}
	}
	public static String addSpace(String s, int n) {
		String re = s;
		for (int i = 0; i < n - s.length(); i++) {
			re += " ";
		}
		return re;
	}

	@Override
	public String toString() {
		return "Fighter " + addSpace(name,8) + " (HP=" + FixInt.addZero(hp, 99) + ")" ;
	}

	public Fighter(String name, int hp, int pow, boolean alive) {
		this.name = name;
		this.hp = hp;
		this.pow = pow;
		this.alive = alive;
	}

	public Fighter(String name) {
		this();
		this.name = name;
	}

	public Fighter() {
		this.hp = 3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getPow() {
		return pow;
	}

	public void setPow(int pow) {
		this.pow = pow;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public boolean isPowP() {
		return powP;
	}

	public void setPowP(boolean powP) {
		this.powP = powP;
	}

	public boolean isDefP() {
		return defP;
	}

	public void setDefP(boolean defP) {
		this.defP = defP;
	}
}
