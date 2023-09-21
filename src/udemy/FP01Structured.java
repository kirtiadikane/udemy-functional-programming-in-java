package udemy;

import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		
		//printAllNumbersInListStructured(List.of(88,9,2,43,71,8,22,12,13,9));  //List.of is introduced in Java9
		//In java8, Arrays.asList is a good alternative
		
		List<Integer> numbers = List.of(88,9,2,43,71,8,22,12,13,9);
		printAllNumbersInListStructured(numbers);
		
		System.out.println("Even numbers:");
		printEvenNumbersInListStructured(numbers);
        
	}

	private static void printAllNumbersInListStructured(List<Integer> numbers) {
		// How to loop the numbers
		for(int number: numbers) {
			System.out.println(number);
		}
	}

	private static void printEvenNumbersInListStructured(List<Integer> numbers) {
		// How to loop the numbers
		for(int number: numbers) {
			if(number%2==0) {
				System.out.println(number);
			}
		}
	}
	
}
