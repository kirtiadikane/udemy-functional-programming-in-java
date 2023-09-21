package udemy.lambda.stream;

import java.util.List;

public class FP01FunctionalLambdaExpExcercises{
	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(3,13,88,90,7,78,45,39,22,44,17);
		//Exercise 1
		System.out.println("Odd numbers:");
		printOddNumbersInList(numbers);
		
		
		List<String> courses = List.of("Spring", "Spring boot", "DevOps", "AWS", "GCP", "MERN");
		
		//Exercise 2
		System.out.println("\nPrint all courses:");
		
		courses.stream()
		.forEach(System.out::println);
		
		//Exercise 3
		System.out.println("\nPrint Courses containing the word spring:");
		
		courses.stream()
		.filter(course -> course.contains("Spring"))
		.forEach(System.out::println);
		
		//Exercise 4
		System.out.println("\nPrint Courses whose name has atleast 4 letters:");
		
		courses.stream()
		.filter(course -> course.length() >= 4)
		.forEach(System.out::println);
		
		//Exercise 5
		System.out.println("\nCube of numbers:");
		numbers.stream()
		.filter(number -> number%2 !=0)
		.map(number -> number*number*number)
		.forEach(System.out::println);
		
		//Exercise 6
		System.out.println("\nPrint the no. of characters in each course name:");
	    courses.stream()
	    .map(course -> course + " = " + course.length())
	    .forEach(System.out::println);
	    
	}

	
	private static void printOddNumbersInList(List<Integer> number){
		number.stream()  //convert to stream
		.filter(num -> num%2 != 0)  //lambda exp
		.forEach(System.out::println);	//method reference
		
	}
	

}

