/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlinggame;

/**
 *
 * @author dbc01
 */
public class BowlingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public int getScore(String values){
        int score;
        score = 0;
        
        if (values.length()<48)
        {
            score = -1;
            return score;
        }
        //  dirty
        int[] throwNumbers = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        throwNumbers[0] = Character.getNumericValue(values.charAt(1));
        throwNumbers[1] = Character.getNumericValue(values.charAt(3));
        throwNumbers[2] = Character.getNumericValue(values.charAt(6));
        throwNumbers[3] = Character.getNumericValue(values.charAt(8));
        throwNumbers[4] = Character.getNumericValue(values.charAt(11));
        throwNumbers[5] = Character.getNumericValue(values.charAt(13));
        throwNumbers[6] = Character.getNumericValue(values.charAt(16));
        throwNumbers[7] = Character.getNumericValue(values.charAt(18));
        throwNumbers[8] = Character.getNumericValue(values.charAt(21));
        throwNumbers[9] = Character.getNumericValue(values.charAt(23));
        throwNumbers[10] = Character.getNumericValue(values.charAt(26));
        throwNumbers[11] = Character.getNumericValue(values.charAt(28));
        throwNumbers[12] = Character.getNumericValue(values.charAt(31));
        throwNumbers[13] = Character.getNumericValue(values.charAt(33));
        throwNumbers[14] = Character.getNumericValue(values.charAt(36));
        throwNumbers[15] = Character.getNumericValue(values.charAt(38));
        throwNumbers[16] = Character.getNumericValue(values.charAt(41));
        throwNumbers[17] = Character.getNumericValue(values.charAt(43));
        throwNumbers[18] = Character.getNumericValue(values.charAt(46));
        throwNumbers[19] = Character.getNumericValue(values.charAt(48));
        
        for (int i=0; i<=19; i++){
            score=score+throwNumbers[i];
        }
        
        return score;
    }
    
}
