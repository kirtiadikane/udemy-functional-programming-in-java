package udemy;

import java.util.List;

public class FP01Functional3LambdaExp {

	public static void main(String[] args) {
		
		List<Integer> numberss = List.of(88,9,2,43,71,8,22,12,13,9);
		System.out.println("Even numbers:");
		printEvenNumbersInListStructured(numberss);
	}

//	private static boolean isEven(int num) {
//		return num%2==0;
//	}
//	
	private static void printEvenNumbersInListStructured(List<Integer> numbers) {
		numbers.stream()
		//.filter(FP01Functional3LambdaExp :: isEven) //filter - only allow even numbers
		.filter(number -> number%2 == 0 )   //Lambda Expression
		.forEach(System.out::println); //method reference
	}

}
