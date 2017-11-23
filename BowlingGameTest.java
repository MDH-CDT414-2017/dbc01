/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlinggame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dbc01
 */
public class BowlingGameTest {
    
    public BowlingGameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class BowlingGame.
     */
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
}
