


public class Field {
	
	private final int rolls;
	private int cash;
	private int dieTotal;
	
	public Field(){
		rolls = 1000000;
		cash = 0;
	}
	
	public Field(int numRolls){
		rolls = numRolls;
		cash = 0;
	}
	/*
	public void execute(){
		MultiDie die1 = new MultiDie();
		MultiDie die2 = new MultiDie();
			
		for(int x = 0; x < rolls; x++){
			die1.roll();
			die2.roll();
			dieTotal = die1.getFaceValue() + die2.getFaceValue();
			System.out.println(dieTotal);
			adjustmoney(dieTotal);
		}
		System.out.println(cash);
	}
	*/
	public void setDieTotal(){
		MultiDie die1 = new MultiDie();
		MultiDie die2 = new MultiDie();
		die1.roll();
		die2.roll();
		dieTotal = die1.getFaceValue() + die2.getFaceValue();
	}
	
	public int getDieTotal(){
		System.out.println(dieTotal);
		return dieTotal;
	}
	
	public void exec(){
		for(int x = 0; x < rolls; x++){
			setDieTotal();
			getDieTotal();
			adjustmoney(dieTotal);
		}
		System.out.println("Total over/under: $" + cash);
		double avg = (double)cash/(double)rolls;
		
		System.out.println("Average money won or lost per roll: $" + avg);
	}
	
	public void exec(int rolls){
		for(int x = 0; x < rolls; x++){
			setDieTotal();
			getDieTotal();
			adjustmoney(dieTotal);
		}
		System.out.println("Total over/under: $" + cash);
		System.out.println("Average money won or lost per roll: " + cash * -1/rolls);

	}
	
	private int adjustmoney(int dieTotal){
		
		switch(dieTotal){
			case 2:
				cash = cash + 20;
				System.out.println("+20");
				break;
			case 12:
				cash = cash + 20;
				System.out.println("+20");
				break;
			case 3:
				cash = cash + 10;
				System.out.println("+10");
				break;
			case 4:
				cash = cash + 10;
				System.out.println("+10");
				break;
			case 9:
				cash = cash + 10;
				System.out.println("+10");
				break;
			case 10:
				cash = cash + 10;
				System.out.println("+10");
				break;
			case 11:
				cash = cash + 10;
				System.out.println("+10");
				break;
			default:
				cash = cash - 10;
				System.out.println("-10");
				break;
			}
		return cash;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Field play = new Field();
			play.exec();
	}

}
