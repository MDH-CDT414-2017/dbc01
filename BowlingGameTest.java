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
        assertEquals(result,-1);
                
    }
    
}
