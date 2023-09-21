package udemy;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		
		printAllNumbersInListFunctional(List.of(88,9,2,43,71,8,22,12,13,9));  //List.of is introduced in Java9
		//In java8, Arrays.asList is a good alternative
        
	}

	private static void printNum(int number) {
		System.out.println(number);
	}
	
	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		//What to do
		numbers.stream()
		.forEach(FP01Functional::printNum); //Method Reference
	
		// How to loop the numbers
//		for(int number: numbers) {
//			System.out.println(number);
//		}
	}
		
}
