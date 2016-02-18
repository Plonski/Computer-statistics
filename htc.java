package htx;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class htc {
	
	public static void flip(int expCount, String combo){
		int outcome, httCount = 0, avgCount = 0;
		
		int[] dei = new int[3];
		int [] translate = new int[3];
		
		
		for(int i = 0; i <= 2; i++){
			char curChar = combo.charAt(i);
			if(curChar == 'h'){
				dei[i] = 1;
			}
			else{
				dei[i] = 2;
			}
		}
		
		for(int i = 0; i < expCount; i++){
			Random r = new Random();
			int[] array = new int[3];
			while(Arrays.equals(dei, array) != true){
				outcome = r.nextInt(2) + 1;
				if(outcome == 1){
					System.out.print("h");
					array[0] = array[1];
					array[1] = array[2];
					array[2] = 1;
					
					httCount++;
				}
				else{
					System.out.print("t");
					array[0] = array[1];
					array[1] = array[2];
					array[2] = 2;
					
					httCount++;
				}
			
			}
			System.out.println(httCount);
			avgCount += httCount;
			httCount = 0;
		}
		System.out.println(avgCount/expCount);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("How many trys do you want? ");
		Scanner scan = new Scanner(System.in);
		int expCount = scan.nextInt();
		System.out.println("What 3 flip pattern are you looking for? ");
		Scanner s = new Scanner(System.in);
		String value  = s.nextLine();
		flip(expCount, value);
	}

}
