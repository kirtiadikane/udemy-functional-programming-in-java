package udemy.lambda.FI.section8;

import java.util.ArrayList;

//Step 01 - Modifying lists with replaceAll and removeIf

import java.util.List;

public class Step1_ModifyingLists {

	public static void main(String[] args) {

		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","API","AWS", "PCF","Azure", "Docker", "Kubernetes");
		System.out.println("courses - " + courses);
		//op: courses - [Spring, Spring Boot, API, Microservices, API, AWS, PCF, Azure, Docker, Kubernetes]
		
		/*
		 * List.of() is a immutable collection, so following code will throw an
           Exception in thread "main" java.lang.UnsupportedOperationException
		 */
		//courses.replaceAll(course -> course.toUpperCase()); 
		
		List<String> modifyableCourses = new ArrayList<>(courses);
		
		modifyableCourses.removeIf(course -> course.length() < 6);
		System.out.println("\nmodifyableCourses whose title length is less than six - " +  modifyableCourses);
		//op: modifyableCourses whose title length is less than six - [Spring, Spring Boot, Microservices, Docker, Kubernetes]
		
		modifyableCourses.replaceAll(course -> course.toUpperCase());
		System.out.println("\nmodifyableCourses in uppercase- " +  modifyableCourses);
		//op: modifyableCourses in uppercase- [SPRING, SPRING BOOT, MICROSERVICES, DOCKER, KUBERNETES]

	}

}
