package craps;

import craps.MultiDie;

public class play {

	public static void main(String[] args) {
		Initiate x = new Initiate(100000);
		x.countExecutes();
		System.out.println(x.toString());
	}

}
