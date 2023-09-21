package udemy;

import java.util.List;

public class FP01Functional2 {

	public static void main(String[] args) {
		
		List<Integer> numberss = List.of(88,9,2,43,71,8,22,12,13,9);
		printAllNumbersInListFunctional(numberss);  //List.of is introduced in Java9
		//In java8, Arrays.asList is a good alternative
		System.out.println("\nEven numbers:");
		printEvenNumbersInListStructured(numberss);
	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
		.forEach(System.out::println); //Method Reference
	}

	private static boolean isEven(int num) {
		return num%2==0;
	}
	
	private static void printEvenNumbersInListStructured(List<Integer> numbers) {
		numbers.stream()
		.filter(FP01Functional2::isEven) //filter - only allow even numbers
		.forEach(System.out::println); //method reference
	}

}
