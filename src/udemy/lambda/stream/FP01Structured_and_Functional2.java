package udemy.lambda.stream;

import java.util.List;

public class FP01Structured_and_Functional2 {

	public static void main(String[] args) {
		
		//printAllNumbersInListStructured(List.of(88,9,2,43,71,8,22,12,13,9));  //List.of is introduced in Java9
		//In java8, Arrays.asList is a good alternative
		
		List<Integer> numbers = List.of(88,9,2,43,71,8,22,12,13,12,9,10);

        System.out.println("Sum of all numbers:");
          
        int sum1 = functional_sumOfAllNumbers(numbers);
        System.out.println(sum1);
        
        System.out.println(numbers.stream().reduce(0, (x,y) -> x));
        System.out.println(numbers.stream().reduce(0, (x,y) -> y));
        System.out.println(numbers.stream().reduce(0, (x,y) -> x>y ? x: y));
        System.out.println(numbers.stream().reduce(Integer.MIN_VALUE, (x,y) -> x>y ? x: y));
        System.out.println(numbers.stream().reduce(Integer.MAX_VALUE, (x,y) -> x>y ? x: y));
        System.out.println(numbers.stream().reduce(Integer.MIN_VALUE, (x,y) -> x>y ? y: x));
        System.out.println(numbers.stream().reduce(Integer.MAX_VALUE, (x,y) -> x>y ? y: x));
    }

//	0 88
//	88 9
//	97 2
//	99 43
//	142 71
//	213 8
//	221 22
//	243 12
//	255 13
//	268 9
//	277
	private static int sumOfNum(int aggregator, int nextNumber) {
		System.out.println(aggregator+ " " + nextNumber);
		return aggregator + nextNumber;
	}
	private static int functional_sumOfAllNumbers(List<Integer> numbers) {		
    	//stream of number -> one result value
    	//combine them into one result -> one value  	
    	return numbers.stream()
    		//	.reduce(0, FP01Structured_and_Functional2::sumOfNum);  //approach 1
    		//	.reduce(0, (x,y) -> x+y);  //approach 2
    	.reduce(0, Integer::sum); //approach 3
	}
	
}
