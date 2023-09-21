package udemy.lambda.FI.section6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Step1CreatingStreams {

	public static void main(String[] args) {
		
		/*
		 * List
		 */
		List<Integer> numlist = Arrays.asList(12,11,2,3,1,5,2,4);
		System.out.println("numlist - "+ numlist); 
		//numlist - [12, 11, 2, 3, 1, 5, 2, 4]
		
		System.out.println("numlist -> Class is Reference- "+ numlist.stream()); 
		//numlist -> Class is Reference- java.util.stream.ReferencePipeline$Head@33833882
		//ReferencePipeline- This hold instances of Wrapper/Custom classes
		
		/*
		 * Stream
		 */
		//Way to create stream of Integers
		System.out.println("\nStream of integers- "+ Stream.of(1,1,2,3,1,5,2,4).toList());
		//Stream of integers- [1, 1, 2, 3, 1, 5, 2, 4]
		
		System.out.println("\nStream count- "+ Stream.of(1,1,2,3,1,5,2,4).count());
		//Stream count- 8
		
		System.out.println("\nStream reduce and sum- "+ Stream.of(1,1,2,3,1,5,2,4).reduce(0, Integer::sum) );
		//Stream reduce and sum- 19
		
		System.out.println("\nStream -> Class is Reference- "+ Stream.of(1,1,2,3,1,5,2,4));
		//Stream -> Class is Reference- java.util.stream.ReferencePipeline$Head@b065c63
		
		/*
		 * Array of Wrapper Integer
		 */
		Integer[] wrapperNumbersArray = {9,8,1,3};
		System.out.println("\nWrapper class Array-> wrapperNumbersArray toString()- "+ Arrays.toString(wrapperNumbersArray) + 
				"\nwrapperNumbersArray asList()- "+ Arrays.asList(wrapperNumbersArray)); 	
		//Wrapper class Array-> wrapperNumbersArray toString()- [9, 8, 1, 3]
		//wrapperNumbersArray asList()- [9, 8, 1, 3]
		
		
		//Creating array with primitive values
		int[] primitiveNumArray = {1,1,2,3,1,67,5,2,4};
		System.out.println("\nPrimitive type array-> primitiveNumArray toString- " + Arrays.toString(primitiveNumArray));
		//Primitive type array-> primitiveNumArray toString- [1, 1, 2, 3, 1, 67, 5, 2, 4]
		
		System.out.println("primitiveNumArray stream-> - ");  
		Arrays.stream(primitiveNumArray)
		.forEach(System.out::println);
//		primitiveNumArray stream-> - 
//		1
//		1
//		2
//		3
//		1
//		67
//		5
//		2
//		4
		
		System.out.println("\nprimitiveNumArray -> Class is IntPipeline- " + Arrays.stream(primitiveNumArray));
		//primitiveNumArray -> Class is IntPipeline- java.util.stream.IntPipeline$Head@46f5f779
		
		System.out.println("\nprimitiveNumArray sum: "+ Arrays.stream(primitiveNumArray).sum());
		//primitiveNumArray sum: 86
		
		System.out.println("\nprimitiveNumArray average: "+ Arrays.stream(primitiveNumArray).average());
		//primitiveNumArray average: OptionalDouble[9.555555555555555]
		
		System.out.println("\nmax number in primitiveNumArray: "+ Arrays.stream(primitiveNumArray).max());
		//max number in primitiveNumArray: OptionalInt[67]
		
		System.out.println("\nprimitiveNumArray min: "+ Arrays.stream(primitiveNumArray).min());
		//primitiveNumArray min: OptionalInt[1]
	}

}
