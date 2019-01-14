package se.lexicon.Li.ArenaFight;

import java.util.Scanner;

public class App {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		String[] randomName = { "Svea", "Alfred", "Rut", "Hannele", "Kasper", "Melker", "Baltsar", "August", 
				"Erland", "Gunder", "Sigurd", "Sigbritt", "Felix", "Anton", "Agnes", "Henrik", "Karl", "Torgny", 
				"Gunhild", "Joar", "Max", "Anselm", "Agda", "Doris", "Rikard", "Bert", "Fanny", "Inge", "Evy" };
		Fighter p1 = new Fighter(), bot = new Fighter();
		Round rou = new Round();

		boolean run = true, newP1 = true,
				// v for valid
				vChoos = false, vName = false;

		while (run) {
			rou.restR();
			if (rou.getFightN() % 5 != 0) {
				bot = new Fighter(bot.getRName(randomName), FixInt.randomInt(6, 4) + rou.getFightN(), 0, true);
			} else {
				bot = new Fighter("Boss " + bot.getRName(randomName), 10 + rou.getFightN(), 0, true);
			}
			// Make new player
			if (newP1) {
				pl("Welcome to The Arena!!!");
				pt("Enter your name:");
				vName = false;
				while (!vName) {
					p1 = new Fighter(scan.nextLine(), 20, 0, true);
					if (p1.getName().equals("Draw")) {
						pl("Not vaild name!!!");
					} else {
						vName = true;
					}
				}
				rou.setFightN(1);
				newP1 = false;
			} else {
				pl("Welcome back to The Arena, " + p1.getName());
			}
			pl();
			p1.savepLog(p1.infFighter(p1.getName(), bot.getName(), rou.getFightN()));

			// The fighting part
			while (p1.isAlive() && bot.isAlive()) {
				rou.goToNextRound();
				pl("Round " + rou.getRoundN() + " :");
				pl(p1);
				pl("vs");
				pl(bot);
				pl("1-Fight, 2-Surrender");

				switch (FixInt.getIntFromLimit(2, 1)) {
				case 1:
					p1.setPow(rou.rollDice());
					bot.setPow(rou.rollDice());
					if (p1.isPowP()) {
						p1.setPow(p1.getPow() + 1);
					}
					rou.saveLog(Battle.fightLog(p1, bot, rou.getRoundN()));

					p1.setHp(p1.getHp() + Battle.battleRes(p1, Battle.getWin(p1, bot)));
					if (p1.isDefP() && Battle.getWin(p1, bot).equals(bot.getName())) {
						p1.setHp(p1.getHp() + 1);
					}
					bot.setHp(bot.getHp() + Battle.battleRes(bot, Battle.getWin(p1, bot)));

					pl("---------------------");
					break;
				case 2:
					rou.saveLog("You surrender.");
					p1.setAlive(false);
					break;
				}
				p1.stillAlive();
				bot.stillAlive();
				pl();
			}
			if (!p1.isAlive() && p1.getHp() != 0) {
				p1.savepLog("At round " + rou.getRoundN() + " You choos to surrender.\n");
			} else {
				p1.savepLog(p1.infRes(rou.getRoundN(), Battle.getWin(p1, bot)) + "\n");
			}

			pl();
			rou.printFullLog();
			pl("Fight " + rou.getFightN() + ", Game Set!!!!!");
			if (rou.getFightN() % 4 == 0) {
				pl("Boss fight next.");
			}
			pl();

			p1.setDefP(false);
			p1.setPowP(false);

			// After win
			if (p1.isAlive()) {
				int rewarde = 0;
				if (rou.getFightN() % 5 == 0) {
					rewarde = FixInt.randomInt(7, 5) + rou.getFightN() * 3;
				} else {
					rewarde = FixInt.randomInt(7, 5) + rou.getFightN() * 2;
				}

				pl(p1 + ", +" + rewarde + "g");
				p1.setBalance(p1.getBalance() + rewarde);
				vChoos = false;
				while (!vChoos) {
					pl("1-Next Fight, 2-Shop(Balance: " + p1.getBalance() + "g), 3-Fighter´s log, 0-Retire");
					switch (FixInt.getIntFromLimit(3, 0)) {
					case 0:
						p1.setAlive(false);
						p1.setHp(0);
						vChoos = true;
						break;
					case 1:
						vChoos = true;
						rou.setFightN(rou.getFightN() + 1);
						break;
					case 2:
						Battle.inShop(p1);
						break;
					case 3:
						p1.printlog();
						break;
					}
				}

			}

			// when you lost
			if (!p1.isAlive() || p1.getHp() == 0) {
				p1.printlog();
				run = YOrN.bool("New Fighter?(y/n)");
				newP1 = true;
			}

		}

		pl("---------------------------------\nGame Over");
	}

	/**
	 * print an empty line
	 */
	public static void pl() {
		System.out.println();
	}

	/**
	 * System.out.println(s);
	 * 
	 * @param s
	 */
	public static void pl(String s) {
		System.out.println(s);
	}

	public static void pl(Fighter p) {
		System.out.println(p);
	}

	/**
	 * System.out.print(s);
	 * 
	 * @param s
	 */
	public static void pt(String s) {
		System.out.print(s);
	}
}
