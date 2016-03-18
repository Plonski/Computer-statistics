import java.util.Arrays;
import java.util.Random;


/* By Thomas Plonski
 * 
 * Two bags of marbles. 
 * 
 * Bag 1 contents: 70 white marbles and 30 black marbles
 * Bag 2 contents: 50 white marbles and 50 black marbles
 * 
 * Randomly decided which bag to choose from first
 * If the most recent marble chosen is white then Bag 1 will be chosen from for the subsequent bag
 * If the most recent marble chosen is black then Bag 2 will be chosen from for the subsequent bag
 */


public class MarbleRoll {
	
	private int bagA[] = new int[100];
	private int bagB[] = new int[100];
	private int Bag;
	private int wCount, bCount, drawCount = 0;
	Random rand = new Random();
	
	private int currMarble;
	
	public MarbleRoll(int drawCount){
		int wMarble, bMarble = 0;
		this.drawCount = drawCount;
	}
	
	public void marbleBags(){
		//Populates the marble bags
		for(int i = 0; i <= 99; i++){
			// Bag A indices 1-70 will be white marbles (1)
			// Bag A indices 71-100 will be black marbles (0)
			if(i <= 70){
				bagA[i] = 1;
			}
			if(i >71){
				bagA[i] = 0;
			}
			// Bag B indices 1-50 will be white marbles (1)
			// Bag B indices 51-100 will be black marbles (0)
			if(i <= 50){
				bagB[i] = 1;
			}
			if(i > 50){
				bagB[i] = 0;
			}
		}
		System.out.println(Arrays.toString(bagA));
	}
	
	private int selectBag(){
		// Selects the initial Bag
		Bag=rand.nextInt(2);
		return Bag;
	}
	
	private void initialDraw(){
		currMarble = rand.nextInt(99);
		System.out.println(currMarble);
		if(Bag == 0){	// Bag A
			if(currMarble <= 70){
				wCount++;
				subsDraw(Bag);
			}
			else{
				bCount++;
				Bag = 1;	// Sets current Bag to bag B
				subsDraw(Bag);
			}
		}
		else{		//	Bag B
			if(currMarble <= 50){
				wCount++;
				Bag = 0;	// Sets current Bag to bag A
				subsDraw(Bag);
			}
			else{
				bCount++;
				subsDraw(Bag);
			}
			
		}
	}
	
	private void subsDraw(int bagNum){
		int i = 1;
		
		while (i < drawCount){
			currMarble = rand.nextInt(99);
			System.out.println(currMarble);
			if(Bag == 0){
				if(currMarble <= 70){
					wCount++;
					i++;
					continue;
				}
				else{
					bCount++;
					Bag = 1;
					i++;
					continue;
				}
			}
			else{
				if(currMarble <= 50){
					wCount++;
					Bag = 0;
					i++;
					continue;
				}
				else{
					bCount++;
					i++;
					continue;
				}
				
			}
		
		}
	}
	
	public String toString(){
		double percent = (double)wCount/(double)drawCount;
		String calculations =   "**************************\n"+
								"White marble count: " + wCount+
								"\nBlack marble count: " + bCount+
								"\nWhite to Black ratio: " + 
								wCount + " : " + bCount + 
								"\nPercentage of white marbles : "+ 
								percent +
								"\n**************************";
		return calculations;
		
	}

	public static void main(String[] args) {
		MarbleRoll roll = new MarbleRoll(1000000);
		roll.marbleBags();
		roll.selectBag();
		roll.initialDraw();
		System.out.println(roll);
	}
}
