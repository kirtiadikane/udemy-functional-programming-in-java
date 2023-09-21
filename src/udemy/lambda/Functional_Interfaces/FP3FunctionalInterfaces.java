package udemy.lambda.Functional_Interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP3FunctionalInterfaces {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(77,23,8,2,7,22,14,56,89);
		
		Predicate<Integer> isEvenPredicate = x -> x%2==0;
		
		Function<Integer,Integer> squareFunction = x -> x* x;
		
		Function<Integer,String> stringFunction = x -> x + "kirti" ;
		
		Consumer<Integer> sysoutConsumer = System.out::println;
		
		
		
		System.out.println("Functional Interfaces");
		numbers.stream()
		.filter(isEvenPredicate)
		.map(squareFunction)
		.forEach(sysoutConsumer);
		
		System.out.println("Consumer");
		
		Consumer<? super String> sysoutConsumerString = System.out::println;
		numbers.stream().
         map(stringFunction)
         .forEach(sysoutConsumerString);
		
		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;//(x,y) -> x+y;
		int sum = numbers.stream()
		.reduce(0, sumBinaryOperator);
         
		System.out.println("sumBinaryOperator: "+ sum);
		
		
		//No input -> return something
		Supplier<Integer> randomIntegerSupplier = //() -> 2;
				()-> {
					Random randomNum = new Random();					
					return randomNum.nextInt(189);  // return random no. less than 189
				};
		System.out.println("randomIntegerSupplier: " + randomIntegerSupplier.get());
		
		
		UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
		System.out.println("\nUnaryOperator: "+ unaryOperator.apply(9));
		
		BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
		System.out.println("\nBinaryOperator: "+ binaryOperator.apply(9 , 5));
		
		BiPredicate<Integer, String> biPredicate = (num, str) -> {
			return num > 10 && str.length() > 5;
		};		
		System.out.println("\nBiPredicate: " + biPredicate.test(11, "kirtii"));
		
		BiPredicate<Integer, String> biPredicate1 = biPredicate.negate();
		System.out.println("BiPredicate: negate() - " + biPredicate1.test(10, "kirti"));
		
		//BiFunction 3rd Param is the type of the result of the function (here String)
		BiFunction<Integer, String, String> biFunction= (num, str) -> {
			return num + " " +str;
		};
		System.out.println("\nBiFunction: " + biFunction.apply(11, "kirtii"));
		
		BiConsumer<String, Integer> biConsumer = (str, num) -> {
			System.out.println("\nBiConsumer: " + str + " " + num);
		};
		biConsumer.accept("keirti", 8);
		
		//When we want to use primitive data types then IntBinaryOperator is efficient to use, 
		//it skips the process of unboxing(Converting an object of a wrapper type (Integer) to its corresponding primitive (int))
		IntBinaryOperator intBinaryOperator = (num1, num2) -> num1 + num2;
		System.out.println("\nIntBinaryOperator: "+ intBinaryOperator.applyAsInt(23, 20));
	}
}
