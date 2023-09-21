package udemy.lambda.stream;

import java.util.List;
import java.util.stream.Collectors;

public class FP3collectCollectorsExercise {

	public static void main(String[] args) {
			
		List<Integer> numbers = List.of(2,5,4,8,12,13,9,2,3,9);
		//Exercise 10
		List<Integer> evenNumList= numbers.stream()
				.filter(num -> num%2==0 )
				.collect(Collectors.toList());
        System.out.println("Create a list with even numbers filtered from the number list: " + evenNumList);
		
		
        List<String> courses = List.of("Spring", "Spring", "Spring boot", "DevOps", "AWS", "GCP", "MERN");
        //Exercise 11
        List<Integer> course_title = courses.stream()
				.map(course -> course.length())
				.collect(Collectors.toList());
        System.out.println("Create a list with lengths of all course titles: " + course_title);
	}
	
}
