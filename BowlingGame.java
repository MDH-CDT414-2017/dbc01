import java.util.Arrays;

public class BowlingGame {

	public static void main(String[] args) {
		// TODO dirty code everywhere

	}
	
	

    public static int[] stringArrayToIntArray(String intString) {
    String str = intString.replaceAll("[^-?0-9]+", " ");
    String[] intStringSplit = str.trim().split(" "); //Split by spaces
    int[] result = new int[intStringSplit.length]; //Used to store our ints
    if (!(intString.matches(".*\\d+.*"))) { //return int array filled with -1 if there is no number in the provided string
    		Arrays.fill(result, -1);
    		return result;
    }
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
    
    
    public boolean checkFormat(String checkThis) {
    	String noStrikeorSpare = "^\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]";
    String lastStrike = "^\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]";
    String lastSpare = "^\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]\\[\\d+\\]";
    	boolean a = checkThis.matches(lastSpare);
    	boolean b = checkThis.matches(lastStrike);
    	boolean c = checkThis.matches(noStrikeorSpare);
    	return (a|b|c);
    }
    
    
    public int getScore(String values){
        int score;
        score = 0;
        boolean[] strike = {false, false, false, false, false, false, false, false, false, false, false, false}; 
        boolean[] spare = {false, false, false, false, false, false, false, false, false, false, false, false}; 
        int[] frameScore = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        boolean invalidNumber = false;
        
        
        /*
         * CHECK STRING CONSISTENCY
         */
        //Parse string and convert to int array
        int[] num = stringArrayToIntArray(values);
        
        //Check if there is a number >10 or <0
        for (int i : num)
        		if(i>10||i<0) invalidNumber = true; 
        
        //Check string consistency
        if (!checkFormat(values)||invalidNumber){
            return -1;
        }
        
        
        /*
         * CALCULATE GAME SCORE
         */
        int lastStrike=9; //Indicator if there is a last strike
        if (num.length>21)
        		lastStrike=10;
        
        
        //Check each frame if Strike or Spare
        for (int i=0; i<=lastStrike; i++){
        strike[i]=checkStrike(num[2*i],num[2*i+1]);
        spare[i]=checkSpare(num[2*i],num[2*i+1]);
        frameScore[i]=num[2*i]+num[2*i+1];
        }
        
        //Game score calculation logic
        for (int i=0; i<=lastStrike; i++){
        //Check for strikes 
            if (strike[i]){ 
                if (strike[i+1]){ //check if two strikes in a row
                        score=score+frameScore[i]+frameScore[i+1]+num[2*(i+2)];
                }
                else
                    score=score+frameScore[i]+frameScore[i+1];
            }
            else if (spare[i]){ //Check spares
                score=score+frameScore[i]+num[2*(i+1)];
                continue;
            }
            else if (i!=10)
            score=score+frameScore[i]; //if last was strike skip this
            
        
        }
        
        return score;
    }
	
	

}
