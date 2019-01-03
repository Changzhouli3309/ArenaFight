package se.lexicon.Li.ArenaFight;

public class Fighter {
	private String name;
	private int hp=3,pow=0;
	private boolean alive=true;
	private String[] pLog=new String[0];
	
	/**
	 * Massage tells names of fighters and number of fight
	 * @param p1 :Name of fighter 1
	 * @param p2 :Name of fighter 2
	 * @param fightN Number of fight
	 * @return String
	 */
	public String infFighter(String p1,String p2,int fightN){
		return "Fight "+fightN+": "+p1+" vs "+p2;
	}
	
	/**
	 * Massage tells number of round and winner of fight
	 * @param rN :Number of round
	 * @param win :winner of fight
	 * @return String
	 */
	public String infRes(int rN,String win) {
		return "At round "+rN+" "+ win+" win";
	}
	
	/**
	 * Save text to battle log of player
	 * @param s :Text to save
	 */
	public void savepLog(String s) {
		pLog=FixArr.addToArr(pLog,s);
	}
	
	public void printlog() {
		System.out.println("---------------------------------");
		System.out.println("Fighter "+name+"´s record:");
		for (String s:pLog) {
			System.out.println(s);
		}
		if (alive) {
			
			System.out.println("---------------------------------");
		}else {
			System.out.println("Fighter "+name+" is retired.");
			System.out.println("End------------------------------");
		}
		
	}

	/**
	 * Get a random String from a String arrays
	 * @param s :String arrays
	 * @return 
	 */
	public String getRName(String[]s) {
		return s[FixInt.randomInt(s.length, 0)];
	}
	
	/**
	 * Check the hp for fighter.
	 */
	public void stillAlive() {
		if (getHp()==0) {
			setAlive(false);
		}
	}
	
	@Override
	public String toString() {
		return "Fighter " + name + ", HP=" + hp + ", Pow=" + pow;
	}
	public Fighter(String name, int hp, int pow, boolean alive) {
		this.name = name;
		this.hp = hp;
		this.pow= pow;
		this.alive = alive;
	}
	public Fighter(String name) {
		this();
		this.name = name;
	}
	public Fighter() {
		this.hp=3;
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
}
