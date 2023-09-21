package udemy.lambda.FI.section7;

//Step 03 - FP and Performance - Intermediate Stream Operations are Lazy

import java.util.List;
import java.util.stream.Collectors;

public class Step3_Intermediate_and_TerminalStreamOperation {

	public static void main(String[] args) {

		List<String> courseList = List.of("Spring", "Spring Boot", "API" , "Microservices","API","AWS", "PCF","Azure", "Docker", "Kubernetes");

		/**
		 * courses whose length is greater than a specific number and 
		 then I would want to uppercase them 
		 */				
		System.out.println("1.peek");
//		op: 1.peek
//		Spring
//		Spring Boot
//		API
//		Microservices
//		API
//		AWS
//		PCF
//		Azure
//		Docker
//		Kubernetes
		
		System.out.println("\n1. Result- course list : " +
				courseList.stream()
		.peek(System.out::println)
		.filter(course -> course.length() > 10)
		.map(course-> course.toUpperCase())   //one way to do uppercase
		.collect(Collectors.toList())         //terminal operation
				);
//		op: 1. Result- course list : [SPRING BOOT, MICROSERVICES]


		/**
		 * courses whose length is greater than a specific number and 
		   then I would want to uppercase them and then I would want to find the first among them.     
		 */

		System.out.println("\n2.peek");
//		op: 2.peek
//		Spring
//		Spring Boot
//		API
//		Microservices
//		MICROSERVICES
		
		System.out.println("\n2. Result- findFirst : " + 
				courseList.stream()
		.peek(System.out::println)
		.filter(course -> course.length() > 11)
		.map(String:: toUpperCase)              //2nd way to do uppercase
		.peek(System.out::println)
		.findFirst() );                         //terminal operation
//		op: 2. Result- findFirst : Optional[MICROSERVICES]
		
		
		
		/**
		 * findFirst() is a terminal operation and others are intermediate operation (map, filter, peek)
           All the intermediate operations on a stream are all lazy.
           When you are defining the intermediate operations, nothing would be executed.
           It's only when the terminal operation is executed, the intermediate operations are executed in Java and that's when it would return the result back.
           And that helps Java to be efficient, when it's executing the terminal operation it knows what is the result.
		 */

	}

}
