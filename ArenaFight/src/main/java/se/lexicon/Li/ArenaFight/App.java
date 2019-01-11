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
		Battle bat = new Battle();
		boolean run = true, newP1 = true,
				// v for valid
				vChoos = false, vName = false;

		while (run) {
			rou.restR();
			bot = new Fighter(bot.getRName(randomName), FixInt.randomInt(5, 2), 0, true);

			// Make new player
			if (newP1) {
				pl("Welcome to The Arena!!!");
				pt("Enter your name:");
				vName = false;
				while (!vName) {
					p1 = new Fighter(scan.nextLine(), 10, 0, true);
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
				pl("Round " + rou.getRoundN() + " :");
				pl(p1);
				pl("vs");
				pl(bot);
				pl("1-Fight, 2-Surrender");

				switch (FixInt.getIntFromLimit(3, 1)) {
				case 1:
					p1.setPow(rou.rollDice());
					bot.setPow(rou.rollDice());

					rou.saveLog(bat.fightLog(p1, bot, rou.getRoundN()));

					p1.setHp(p1.getHp() + bat.battleRes(p1, bat.getWin(p1, bot)));
					bot.setHp(bot.getHp() + bat.battleRes(bot, bat.getWin(p1, bot)));

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
				p1.savepLog("At round " + rou.getRoundN() + " You choos to surrender.+\n");
			} else {
				p1.savepLog(p1.infRes(rou.getRoundN(), bat.getWin(p1, bot)) + "\n");
				rou.goToNextRound();
			}

			pl();
			rou.printFullLog();
			pl("Game Set!!!!!");
			pl();

			// After win
			if (p1.isAlive()) {
				vChoos = false;
				while (!vChoos) {
					pl(p1);
					pl("1-Next Fight, 2-Retire, 3-Fighter´s log");
					switch (FixInt.getIntFromLimit(3, 1)) {
					case 1:
						vChoos = true;
						rou.setFightN(rou.getFightN() + 1);
						break;
					case 2:
						p1.setAlive(false);
						p1.setHp(0);
						vChoos = true;
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

		pl("---------------------------------");
		pl("Game Over");
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
