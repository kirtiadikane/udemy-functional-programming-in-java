package udemy.lambda.Functional_Interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP2BehaviorParameterizationExercise {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(7,23,8,2,27,7,22,14,56,89);
		
		//System.out.print(squaredNumbers(numbers));
//Do Behavior Parameterization for the mapping logic.
//List squaredNumbers = numbers.stream() .map(x -> x*x) .collect(Collectors.toList());
		
		List squareNumbers = mapAndCreateNewList(numbers, x -> x*x);
		
		List cubeNumbers = mapAndCreateNewList(numbers, x -> x*x*x);
		
		List doubledNumbers = mapAndCreateNewList(numbers, x -> x+x);
		
		System.out.println(squareNumbers);	
		System.out.println(cubeNumbers);	
		System.out.println(doubledNumbers);	
	}

	private static List<Integer> mapAndCreateNewList(List<Integer> numbers,
			Function<Integer, Integer> mappingFunction) {
		return numbers.stream() .map(mappingFunction) .collect(Collectors.toList());
	}



}
