package udemy.lambda.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FP01Structured_and_Functional3 {

	public static void main(String[] args) {
			
		List<Integer> numbers = List.of(2,5,9,2,3,9);
		System.out.println("distinct():");
        numbers.stream().distinct().forEach(System.out::println);
        
        System.out.println("sorted():");
        numbers.stream().sorted().forEach(System.out::println);
        		
        System.out.println("distinct() & sorted():");
        numbers.stream().distinct().sorted().forEach(System.out::println);
        
        List<String> courses = List.of("Spring", "Spring", "Spring boot", "DevOps", "AWS", "GCP", "MERN");
        
        System.out.println("\ndistinct() :");
        courses.stream().distinct().forEach(System.out::println);
        
        System.out.println("\nsorted():");
        courses.stream().sorted().forEach(System.out::println);
        
        System.out.println("\nsorted() comparator:");
        courses.stream()
        .sorted(Comparator.naturalOrder())
        .forEach(System.out::println);
        
        System.out.println("\nsorted() comparator reverse order:");
        courses.stream()
        .sorted(Comparator.reverseOrder())
        .forEach(System.out::println);
	
        System.out.println("\nsorted() by length:");
        courses.stream()
        .sorted(Comparator.comparing(kirtistr -> kirtistr.length()))
        .forEach(System.out::println);
       
	
   }

	
}
