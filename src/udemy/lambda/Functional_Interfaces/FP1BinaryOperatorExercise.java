package udemy.lambda.Functional_Interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP1BinaryOperatorExercise {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(77,23,8,2,7,22,14,56,89);
		
		//Find FI behind the second argument of reduce method. Create an implementation for the FI.
//		int sum = numbers.stream().
//				reduce(0, Integer::sum);
		
		BinaryOperator<Integer> sumAccumulator = Integer::sum;
		
		BinaryOperator<Integer> sumAccumulator2 = new BinaryOperator<Integer>() {
			@Override
			public Integer apply(Integer t, Integer u) {
				// TODO Auto-generated method stub
				System.out.println(t +" "+ u);
				return t+u;
			}
		};
				
		int sum = numbers.stream().
				reduce(0, sumAccumulator);
		
		System.out.println("FI Sum: "+sum);
		
		int sum2=numbers.stream().
		reduce(0, sumAccumulator2);
		
		System.out.println("FI Impl Sum: "+sum2);
	}
}
