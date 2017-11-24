import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BowlingGameTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

    @Test
    public void testgetScoreExsists() {
        BowlingGame game = new BowlingGame();
        String data = "pipa";
        int result;
        result = game.getScore(data);
        assertEquals(-1,result);
                
    }
    
    @Test
    public void testgetScoreOpen() {
        BowlingGame game = new BowlingGame();
        String data = "[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]";
        int result;
        System.out.println("Open");
        result = game.getScore(data);
        assertEquals(81,result);       
    }
    @Test
    public void testgetScoreSingleStrike() {
        BowlingGame game = new BowlingGame();
        String data = "[10,0][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]";
        int result;
        System.out.println("Strike");
        result = game.getScore(data);
        assertEquals(94,result);       
    }
    @Test
    public void testgetScoreMultipleStrike() {
        BowlingGame game = new BowlingGame();
        String data = "[10,0][10,0][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]";
        int result;
        System.out.println("Multistrike");
        result = game.getScore(data);
        assertEquals(112,result);       
    }
    @Test
    public void testgetScoreSpare() {
        BowlingGame game = new BowlingGame();
        String data = "[1,9][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]";
        int result;
        System.out.println("Spare");
        result = game.getScore(data);
        assertEquals(88,result);       
    }
    @Test
    public void testgetScoreMultipleSpare() {
        BowlingGame game = new BowlingGame();
        String data = "[8,2][5,5][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]";
        int result;
        System.out.println("Multispare");
        result = game.getScore(data);
        assertEquals(98,result);       
    }
    @Test
    public void testgetScoreStrikeThenSpare() {
        BowlingGame game = new BowlingGame();
        String data = "[10,0][4,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]";
        int result;
        System.out.println("StrikeSpare");
        result = game.getScore(data);
        assertEquals(103,result);       
    }
    @Test
    public void testgetScoreLastSpare() {
        BowlingGame game = new BowlingGame();
        String data = "[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][7]";
        int result;
        System.out.println("LastSpare");
        result = game.getScore(data);
        assertEquals(90,result);       
    }
    @Test
    public void testgetScoreLastStrike() {
        BowlingGame game = new BowlingGame();
        String data = "[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][10,0][7,2]";
        int result;
        System.out.println("LastStrike");
        result = game.getScore(data);
        assertEquals(92,result);       
    }
    @Test
    public void testgetScoreLastSpareThenStrike() {
        BowlingGame game = new BowlingGame();
        String data = "[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][10]";
        int result;
        System.out.println("LastSpareThenStrike");
        result = game.getScore(data);
        assertEquals(93,result);       
    }
    @Test
    public void testgetScorePerfectGame() {
        BowlingGame game = new BowlingGame();
        String data = "[10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,10]";
        int result;
        System.out.println("PerfectGame");
        result = game.getScore(data);
        assertEquals(300,result);       
    }
    
    @Test
    public void testgetScoreLongString() {
        BowlingGame game = new BowlingGame();
        String data = "[10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,10]abc";
        int result;
        System.out.println("LongString");
        result = game.getScore(data);
        assertEquals(-1,result);       
    }
    @Test
    public void testgetScoreInvalidString() {
        BowlingGame game = new BowlingGame();
        String data = "[10,0][10,0][10,0][10,0][10,0][10,0][10,0[10,0][10,0][10,0][10,10]";
        int result;
        System.out.println("LongString");
        result = game.getScore(data);
        assertEquals(-1,result);       
    }
    @Test
    public void testgetScoreToobigNumber() {
        BowlingGame game = new BowlingGame();
        String data = "[10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,11]";
        int result;
        System.out.println("TooBigNumber");
        result = game.getScore(data);
        assertEquals(-1,result);       
    }
    @Test
    public void testgetScoreMoreInvalidString() {
        BowlingGame game = new BowlingGame();
        String data = "[[10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0]";
        int result;
        System.out.println("MoreInvalidString");
        result = game.getScore(data);
        assertEquals(-1,result);       
    }
    @Test
    public void testgetScoreMixedStrikeSpare() {
        BowlingGame game = new BowlingGame();
        String data = "[3,7][10,0][2,5][5,4][10,0][10,0][9,1][6,4][3,7][10,0][10,4]";
        int result;
        System.out.println("MoreInvalidString");
        result = game.getScore(data);
        assertEquals(175,result);       
    }

}
