package udemy.lambda.FI.section6;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Step3BigInteger {

	public static void main(String[] args) {
		
		System.out.println("Integer MAX_VALUE : " + Integer.MAX_VALUE);
		//Integer MAX_VALUE : 2147483647
		
		System.out.println("\nLong MAX_VALUE : " + Long.MAX_VALUE);
		// o/p: Long MAX_VALUE : 9223372036854775807

		System.out.println("\nFactorial of 5 : " + IntStream.rangeClosed(1, 5).reduce(1, (x,y)-> x*y) );
		// o/p: Factorial of 5 : 120
		
		System.out.println("\nFactorial of 50 : " + IntStream.rangeClosed(1, 50).reduce(1, (x,y)-> x*y) );  
	    // o/p: Factorial of 50 : 0   //Factorial of 50 is exceeding the Integer MAX LIMIT, hence we got 0 
		
		System.out.println("\nFactorial of 25 : " + LongStream.rangeClosed(1, 25).reduce(1, (x,y)-> x*y) );  
		// o/p: Factorial of 25 : 7034535277573963776  //Factorial of 25 is within the LONG LIMIT
		
		System.out.println("\nFactorial of 50 : " + LongStream.rangeClosed(1, 50).reduce(1, (x,y)-> x*y) );  
		// o/p: Factorial of 50 : -3258495067890909184  //Factorial of 50 is exceeding the LONG MAX LIMIT, hence we got -3258495067890909184 
	
		System.out.println("\nFactorial of 50 using BIGINT: " + 
		IntStream.rangeClosed(1, 50)
		.mapToObj(BigInteger :: valueOf )
		.reduce(BigInteger.ONE, BigInteger:: multiply ) );
		// o/p: Factorial of 50 using BIGINT: 30414093201713378043612608166064768844377641568960512000000000000
	}

}
