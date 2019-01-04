package se.lexicon.Li.ArenaFight;
import org.junit.*;

public class TestBattle {
	private Fighter tester1;
	private Fighter tester2;
	private Battle testBat = new Battle();
	private final int ROLL_TIMES=500;
	private Round testRou= new Round();
	@Before
	public void init() {
		//Fighter(String name, int hp, int pow, boolean alive)
		tester1 =new Fighter("Test1", 1, 5,true);
		tester2 =new Fighter("Test2", 1, 2,true);
	}
	@Test
	public void test_account_creat() {
		Assert.assertEquals("Test1", tester1.getName());
		Assert.assertEquals(1, tester1.getHp());
		Assert.assertEquals(5, tester1.getPow());
		Assert.assertTrue(tester1.isAlive());
	}
	
	@Test
	public void battle_win_test() {
		String expected="Test1";
		String actual=testBat.getWin(tester1.getPow(), tester2.getPow(), 
				tester1.getName(), tester2.getName());
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void battle_res_test() {
		int expected=-1;
		int actual = testBat.battleRes(tester2.getName(), testBat.getWin(tester1.getPow(), tester2.getPow(), tester1.getName(), tester2.getName()));
		Assert.assertEquals(expected, actual,0);
	}

	@Test
	public void roll_dice_test() {
		int max=6,min=1;
		
		for (int i = 0; i < ROLL_TIMES; i++) {
			int rn = testRou.rollDice();
			Assert.assertTrue(rn <= max&&rn >= min);
		}
	}
}
