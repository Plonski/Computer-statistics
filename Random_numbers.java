package statistics;

import java.util.Arrays;
import java.util.Random;


public class Random_numbers {
	
	
	public static void generate(){
		Random x = new Random();
		int[] arr = new int[100];
		for (int i = 0; i <=99; i++){
			int b = x.nextInt(100);
			arr[i] = b+1;
		}
		
		System.out.println(Arrays.toString(arr));
		mean(arr);
		minAndMax(arr);
	}
	
	public static void mean(int [] array){
		int total = 0;
		
		for (int i = 0; i <=99; i++){
			total += array[i];
			}
		int mean;
		mean = total/100;
		System.out.println("The mean is: "+ mean);
		stdDev(array, mean);
	}
	
	public static void stdDev(int[] array, int mean){
		int [] convertedArray = new int[100];
		int total = 0;
		for(int i = 0; i<=99; i++){
			int x = array[i] - mean;
			convertedArray[i] = x * x;
		}
		for(int i = 0; i<=99; i++){
			total += convertedArray[i];
		}
		int variance = total/100;
		double svariance = Math.sqrt(variance);
		System.out.println("The standard dev. is : "+ svariance);
	}
	
	public static void minAndMax(int [] array){
		int min = 1, max = 1;
		for(int i = 0; i <= 99; i++){
			if(array[i] <= min){
				min = array[i];
			}
			if(array[i] >= max){
				max = array[i];
			}
		}
		System.out.println("The max is: " + max + "\nThe min is: " + min);
	}
	
	
	public static void main(String[]args){
		generate();
	}

}
