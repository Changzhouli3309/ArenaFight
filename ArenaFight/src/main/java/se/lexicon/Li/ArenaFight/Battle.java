package se.lexicon.Li.ArenaFight;

/*Battle –for the battle itself,
 * should make the log of the battle, 
 * as well as references to both the player and the opponent */

public class Battle {

	/**
	 * Message tell the result of fight
	 * 
	 * @param p1 :Class Fighter No.1
	 * @param p2 :Class Fighter 2
	 * @param r  : Number of Rounds
	 * @return String
	 */
	public static String fightLog(Fighter p1, Fighter p2, int r) {
		if (p1.getPow() == p2.getPow()) {
			String re = "Round " + r + ": \n" + p1 + " Power:" + p1.getPow();
			if (p1.isPowP()) {
				re += " (pow up)";
			}
			if (p1.isDefP()) {
				re += " (def up)";
			}

			return re + "\n" + p2 + " Power:" + p2.getPow() + "\nDraw!";
		} else {
			String re = "Round " + r + ": \n" + p1 + " Power:" + p1.getPow();
			if (p1.isPowP()) {
				re += " (pow up)";
			}
			if (p1.isDefP()) {
				re += " (def up)";
			}
			return re + "\n" + p2 + " Power:" + p2.getPow() + "\n" + getWin(p1, p2) + " Win!";
		}
	}

	/**
	 * Get name of the winner of fight
	 * 
	 * @param p1 :Class Fighter 1
	 * @param p2 :Class Fighter 2
	 * @return Name of winner
	 */
	public static String getWin(Fighter p1, Fighter p2) {
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
	public static int battleRes(Fighter p, String win) {
		if (win.equals("Not vaild name")) {
			return 0;
		} else if (p.getName().equals(win)) {
			return 0;
		} else {
			return -2;
		}
	}

	/**
	 * Shop menu
	 * 
	 * @param p1 :Player goes in shop
	 */
	public static void inShop(Fighter p1) {
		boolean inshop = true;
		System.out.println("Welcome to Arena shop!!!(Balance: " + p1.getBalance() + ", 0-Back)"
				+ "\n1-HP potion(+5hp, 10g)(Your hp:" + p1.getHp() + ")"
				+ "\n2-Pow potion(+1 POW, next fight only, 12g)" 
				+ "\n3-Def potion(-1 Dmg, next fight only, 13g)"
				+ "\n4-Try your luck(10% chans get random potion, 5g)");
		while (inshop) {
			switch (FixInt.getIntFromLimit(4, 0)) {
			case 0:
				inshop = false;
				break;
			case 1:
				if (checkBalance(p1.getBalance(), 10)) {
					p1.setBalance(p1.getBalance() - 10);
					p1.setHp(p1.getHp() + 5);
					System.out.println("You buy the Hp potion and drink it.");
				}
				break;
			case 2:
				if (checkBalance(p1.getBalance(), 12) && !p1.isPowP()) {
					p1.setBalance(p1.getBalance() - 12);
					p1.setPowP(true);
					System.out.println("You buy the Pow potion and drink it.");
				} else {
					System.out.println("You already had Pow potion.");
				}
				break;
			case 3:
				if (checkBalance(p1.getBalance(), 13) && !p1.isDefP()) {
					p1.setBalance(p1.getBalance() - 13);
					p1.setDefP(true);
					System.out.println("You buy the Def potion and drink it.");

				} else {
					System.out.println("You already had def potion.");
				}
				break;
			case 4:
				if (checkBalance(p1.getBalance(), 5)) {
					p1.setBalance(p1.getBalance() - 5);
					switch (FixInt.randomInt(9, 0)) {
					case 0:
						System.out.println("Nice! you get the Hp potion and drink it.");
						p1.setHp(p1.getHp() + 5);
						break;
					case 1:
						System.out.println("Nice! you get the Pow potion and drink it.");
						p1.setPowP(true);
						break;
					case 2:
						System.out.println("Nice! you get the Def potion and drink it.");
						p1.setDefP(true);
						break;
					default:
						System.out.println("Sorry! you didn´t get anything.");
						break;
					}
				}
				break;
			}
			System.out.println("Your hp=" + p1.getHp()+", Balance="+p1.getBalance()+"g");
		}
	}

	public static boolean checkBalance(int balance, int price) {
		if (balance >= price) {
			return true;
		} else {
			System.out.println("You don´t have enough money.");
			return false;
		}
	}
}
