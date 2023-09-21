package udemy;

import java.util.List;

public class FP01Structured_and_Functional {

	public static void main(String[] args) {
		
		//printAllNumbersInListStructured(List.of(88,9,2,43,71,8,22,12,13,9));  //List.of is introduced in Java9
		//In java8, Arrays.asList is a good alternative
		
		List<Integer> numbers = List.of(88,9,2,43,71,8,22,12,13,9);

        System.out.println("Sum of all numbers:");
        int sum = structured_sumOfAllNumbers(numbers);
        System.out.println(sum);      
        
//      
        int sum1 = functional_sumOfAllNumbers(numbers);
        System.out.println(sum1);
        
    }
	
	private static int structured_sumOfAllNumbers(List<Integer> numbers) {
    	int sum = 0;
    	for(int number: numbers) {
    		sum += number;
    	}
    	return sum;
	}
	
	private static int sumOfNum(int a, int b) {
		return a+b;
	}
	
	private static int functional_sumOfAllNumbers(List<Integer> numbers) {		
    	//stream of number -> one result value
    	//combine them into one result -> one value  	
    	return numbers.stream()
    			.reduce(0, FP01Structured_and_Functional::sumOfNum);
	}
	
	
}
