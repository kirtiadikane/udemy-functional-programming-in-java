package udemy.lambda.Functional_Interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FP2BehaviorParameterization {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(77,23,8,2,27,7,22,14,56,89,33);
		
		System.out.println("Even: ");
		filterNumbersAndPrint(numbers, x -> x%2==0);
//		op: Even: 
//			8
//			2
//			22
//			14
//			56
			
		System.out.println("\nOdd: ");
		filterNumbersAndPrint(numbers, x -> x%2!=0);
//		op: Odd: 
//			77
//			23
//			27
//			7
//			89
//			33
		
		System.out.println("\nMultiple of 3:");
		filterNumbersAndPrint(numbers, x -> x%3==0);
//		op: Multiple of 3:
//			27
//			33
	}

	private static void filterNumbersAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
		numbers.stream()
		.filter(predicate)
		.forEach(System.out::println);
	}

}
