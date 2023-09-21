package udemy.lambda.stream;

import java.util.List;

public class FP02FunctionalExcerices {

	public static void main(String[] args) {
		
		//printAllNumbersInListStructured(List.of(88,9,2,43,71,8,22,12,13,9));  //List.of is introduced in Java9
		//In java8, Arrays.asList is a good alternative
		
		List<Integer> numbers = List.of(3,2,1,4);
        
       //Exercise 7: 
       System.out.println("Sqaure every no. in a list and find the sum of sqaures=");
       System.out.println(numbers.stream()
    		   .map(x -> x*x)
    		   .reduce(0, Integer::sum));
       
       //Exercise 8
       System.out.println("Cube every no. in a list and find the sum of sqaures=");
       System.out.println(numbers.stream()
    		   .map(x -> x*x*x)
    		   .reduce(0, Integer::sum));
       
       //Exercise 9
       System.out.println("Find the sum of odd numbers in a list=");
       System.out.println(numbers.stream()
    		.filter( x -> x%2 != 0)
    		//.reduce(0, (x,y) -> x+y));
       .reduce(0, Integer::sum));
                
   
    }



}
