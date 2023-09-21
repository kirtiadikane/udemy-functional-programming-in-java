package udemy.lambda.FI.section6;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Step2CreatingStreams {

	public static void main(String[] args) {

		/*
		 * IntStream Class
		 */
		System.out.println("IntStream range sum- " + IntStream.range(1, 10).sum());
		// o/p: IntStream range sum- 45

		System.out.println("\nIntStream range peek sum- ");
		IntStream.range(1, 10).peek(System.out::println).sum();  //10 is excluded in the sum
		//	o/p:
		//		1
		//		2
		//		3
		//		4
		//		5
		//		6
		//		7
		//		8
		//		9

		System.out.println("\nIntStream rangeClosed sum- " + IntStream.rangeClosed(1, 10).sum());//10 is included in the sum
		//IntStream rangeClosed sum- 55

		System.out.println("\nIntStream iterate limit sum- " + IntStream.iterate(1, e -> e+2).limit(5).sum() );
		//IntStream iterate limit sum- 25

		System.out.println("\nIntStream iterate limit peek sum- ");
		IntStream.iterate(1, e-> e+2).limit(5).peek(System.out::println).sum();
		//		1
		//		3
		//		5
		//		7
		//		9

		System.out.println("\nIntStream return the sum of only even numbers- "+ IntStream.iterate(2, even-> even+2).limit(5).sum() ); //2+4+6+8+10=30
		//IntStream return only even numbers- 30

		System.out.println("\nIntStream 2 power- "+ IntStream.iterate(2, e -> e*2).limit(3).sum() ); //2 + 2*2 + 2*2*2 = 14
		//IntStream 2 power- 14

		System.out.println("\nIntStream 2 power result in list- "+ IntStream.iterate(2, e -> e*2)
		.limit(3)
		.boxed().collect(Collectors.toList()) ); 
		//IntStream 2 power result in list- [2, 4, 8]
	}

}
