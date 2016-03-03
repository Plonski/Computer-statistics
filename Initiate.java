package craps;

public class Initiate {
	
	private int rolls;
	private int point;
	private boolean cOut = true;
	private int winCount = 0;
	private int lossCount = 0;
	private int dieTotal;
	
	MultiDie die1 = new MultiDie();
	MultiDie die2 = new MultiDie();
	
	public Initiate(){
		rolls = 100000;
	}
	
	public Initiate(int numRolls){
		rolls = numRolls;
	}
	
	public void countExecutes(){
		for(int x = 0; x < rolls; x++){
			execute();
		}
	}
	
	public void execute(){
		
		die1.roll();
		die2.roll();
		
		dieTotal = die1.getFaceValue() + die2.getFaceValue();
		//System.out.println(dieTotal);
		
		outcome(dieTotal, cOut);
	}
	
	private void execute(boolean cOut){
		
		die1.roll();
		die2.roll();
		
		dieTotal = die1.getFaceValue() + die2.getFaceValue();
		//System.out.println("You rolled " + dieTotal);
		outcome(dieTotal, false);
		
	}
	
	private void outcome(int dieTotal, boolean cOut){
		
		if(cOut == true){
			switch(dieTotal){
			case 2: case 3: case 12:
				System.out.println("You rolled " + dieTotal + ". You crapped out.\n");
				lossCount++;
				break;
			case 7: case 11:
					System.out.println("You rolled " + dieTotal + ". You are a natural.\n");
					winCount++;
					break;
			default:
				System.out.println("Your point is "+ dieTotal);
				point = dieTotal;
				execute(false);
				break;
			}
		}
		else{
			if(dieTotal == 7){
				System.out.println("You got 7. You lose.\n");
				lossCount++;
			}
			else if(dieTotal != point){
				System.out.println("You rolled " + dieTotal + ". Rolling again...");
				execute(false);
			}
			else{
				System.out.println("You got your point "+ point + ". You win.\n");
				winCount++;
			}
		}
		
	}
	
	public String toString(){
		String s = "**************************************\n" +
					"Out of " + rolls + " games: \n" +
				 	"You won " + winCount + " games. \n"+
					"You lost " + lossCount + " games \n"+
					"**************************************\n";
		return s;
		
	}
}
