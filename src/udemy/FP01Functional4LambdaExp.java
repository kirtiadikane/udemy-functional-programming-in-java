package udemy;

import java.util.List;

public class FP01Functional4LambdaExp {

	public static void main(String[] args) {
		
		List<Integer> numberss = List.of(88,9,2,43,71,8,22,12,13,9);
		System.out.println("Square of Even numbers:");
		printSquaresOfEvenNumbersInListStructured(numberss);
	}

//	private static boolean isEven(int num) {
//		return num%2==0;
//	}
//	
	private static void printSquaresOfEvenNumbersInListStructured(List<Integer> numbers) {
		numbers.stream()
		//.filter(FP01Functional3LambdaExp :: isEven) //filter - only allow even numbers
		.filter(number -> number%2 == 0 )   //Lambda Expression
		.map(number -> number*number)  //mapping
		.forEach(System.out::println); //method reference
	}

}
