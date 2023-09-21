package udemy.lambda.FI.section4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class S7_MethodReferences {

	private static void printCourses(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {

		//unmodifiable List 
		List<String> coursesArrays = Arrays.asList("Spring", "Spring boot", "DevOps", "AWS", "GCP", "MERN");

		//unmodifiable List 
		List<String> coursesList = List.of("Spring Framework", "Spring boot", "DevOps", "AWS", "GCP", "MERN");

		System.out.println("coursesArrays in uppercase: ");
		coursesArrays.stream().map(str -> str.toUpperCase())
		.forEach(System.out::println);
//		op: coursesArrays in uppercase: 
//			SPRING
//			SPRING BOOT
//			DEVOPS
//			AWS
//			GCP
//			MERN

		System.out.println("\ncoursesList in lowercase: ");
		coursesList.stream().map(str -> str.toLowerCase())
		.forEach(System.out::println);
//		op: coursesList in lowercase: 
//			spring framework
//			spring boot
//			devops
//			aws
//			gcp
//			mern

		System.out.println("\n1. Method Reference Example coursesList:");
		coursesList.stream()
		.forEach(S7_MethodReferences :: printCourses);
//		op: 1. Method Reference Example coursesList:
//			Spring Framework
//			Spring boot
//			DevOps
//			AWS
//			GCP
//			MERN

		
		System.out.println("\n2. Method Reference Example coursesList:");
		coursesList.stream()
		.map(String :: toUpperCase)
		.forEach(S7_MethodReferences :: printCourses);
//		op: 2. Method Reference Example coursesList:
//			SPRING FRAMEWORK
//			SPRING BOOT
//			DEVOPS
//			AWS
//			GCP
//			MERN
		

		//() -> new String() OR String :: new --> used to create new objects
		Supplier<String> supplier = () -> new String();  //1st way: Constructor reference 
		Supplier<String> supplier1 = String :: new; //2nd way 

		Supplier<String> strSupplier = () -> {
			String name = "\nKirti in Supplier";
			return name;
		};

		System.out.println(strSupplier.get()); 
		//op: Kirti in Supplier

	}

}
