package udemy.lambda.Functional_Interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP1PredicateConsumerFunction {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(77,23,8,2,7,22,14,56,89);
		
		Predicate<Integer> isEvenPredicate = x -> x%2==0;
		
		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				// TODO Auto-generated method stub
				return t%2==0;
			}			
		};
		
		Function<Integer,Integer> squareFunction = x -> x* x;
		
		Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer t) {
				// TODO Auto-generated method stub
				return t*t;
			}
		};
		
		Consumer<Integer> sysoutConsumer = System.out::println;
		
		Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);		
			}
			
		};
		
		System.out.println("Functional Interfaces");
		numbers.stream()
		.filter(isEvenPredicate)
		.map(squareFunction)
		.forEach(sysoutConsumer);
		
		System.out.println("Functional Interfaces Impl");
		numbers.stream()
		.filter(isEvenPredicate2)
		.map(squareFunction2)
		.forEach(sysoutConsumer2);
		
	}

}
