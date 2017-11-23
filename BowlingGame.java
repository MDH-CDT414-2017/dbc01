/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlinggame;

import java.util.Arrays;

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
    
    
    public static int[] stringArrayToIntArray(String intString) {
    String str = intString.replaceAll("[^-?0-9]+", " ");
    String[] intStringSplit = str.trim().split(" "); //Split by spaces
    int[] result = new int[intStringSplit.length]; //Used to store our ints

    for (int i = 0; i < intStringSplit.length; i++) {
        //parse and store each value into int[] to be returned
        result[i] = Integer.parseInt(intStringSplit[i]); 
    }
    return result;
    }
    
    public boolean checkStrike(int a, int b){
        if (a==10&&b==0)
            return true;
        else
        return false;        
    }
    
    public boolean checkSpare(int a, int b)
    {
        if ((!(checkStrike(a,b)))&&((a+b)==10)) return true;
        else return false;
    }
    
    
    @SuppressWarnings("empty-statement")
    public int getScore(String values){
        int score;
        score = 0;
        int holder;
        int ten=10;
        boolean[] strike = {false, false, false, false, false,false,false,false,false,false,false,false}; 
        boolean[] spare = {false, false, false, false, false,false,false,false,false,false,false,false}; 
        int[] frameScore = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        String sampledata = "[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][7,2]";
        
        //Check string consistency
        if (values.length()<48){
            return -1;
        }
        
        int[] num = stringArrayToIntArray(values);
       
        System.out.println(num.length);
        
        int j=9;
        if (num.length>21)
            j=10;
        //get strikes and spares
        
        for (int i=0; i<=j; i++){
        strike[i]=checkStrike(num[2*i],num[2*i+1]);
        spare[i]=checkSpare(num[2*i],num[2*i+1]);
        frameScore[i]=num[2*i]+num[2*i+1];
        }
        for (int i=0; i<=j; i++){
        //Test for strikes 
            if (strike[i]){ 
                if (strike[i+1]){
                        score=score+frameScore[i]+frameScore[i+1]+num[2*(i+2)];
                }
                else
                    score=score+frameScore[i]+frameScore[i+1];
            }
            else if (spare[i]){ //test spares
                score=score+frameScore[i]+num[2*(i+1)];
                continue;
            }
            else if(strike[i]) continue;
            else if (i!=10)
            score=score+frameScore[i]; //no idea why i put it 
            
        
        }
        
        return score;
    }
    
}
