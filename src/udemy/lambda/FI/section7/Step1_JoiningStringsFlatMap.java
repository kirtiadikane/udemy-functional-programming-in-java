package udemy.lambda.FI.section7;

//Step 01 - Joining Strings with joining and Playing with flapMap

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Step1_JoiningStringsFlatMap {

	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","API","AWS", "PCF","Azure", "Docker", "Kubernetes");

		System.out.println("courses - " + courses);
		System.out.println("courses - " + courses.stream().collect(Collectors.toList()) );
		// o/p: courses - [Spring, Spring Boot, API, Microservices, API, AWS, PCF, Azure, Docker, Kubernetes]
		
		System.out.println("\nCollectors joining - " + courses.stream().collect(Collectors.joining("* ")) );
		// o/p: Collectors joining - Spring* Spring Boot* API* Microservices* API* AWS* PCF* Azure* Docker* Kubernetes
		
		String[] str = "Kirti".split("i");
		System.out.println("\nSpring split - ");
		for(String s: str) 
			System.out.print(s);
		//op: Spring split - Krt
		
		System.out.println("\n\nStream of String[] - " + courses.stream()
				.map(course -> course.split(","))
				.collect(Collectors.toList()) );
		//op: Stream of String[] - [[Ljava.lang.String;@4fccd51b, [Ljava.lang.String;@44e81672, [Ljava.lang.String;@60215eee, [Ljava.lang.String;@4ca8195f, [Ljava.lang.String;@65e579dc, [Ljava.lang.String;@61baa894, [Ljava.lang.String;@b065c63, [Ljava.lang.String;@768debd, [Ljava.lang.String;@490d6c15, [Ljava.lang.String;@7d4793a8]

//		Stream of String[] => Stream of String
//		Stream[["S","p","r","i","n","g"],["S","p","r","i","n","g","B","o","t"],...]
//                 =>		
//	    Stream["S","p","r","i","n","g","S","p","r","i","n","g","B","o","t",...]
		
		
		/**
		 * FlatMap: each element of Stream replaced with content of mapped stream
		 * Mapping Function -> (Arrays:stream)
		 * ["S","p","r","i","n","g"] => "S","p","r","i","n","g"
		 * ["A","W","S"] => "A","W","S"
		 */
		System.out.println("\nFlatMap - " + courses.stream()
				.map(course -> course.split(""))
				.flatMap(Arrays :: stream)
				.collect(Collectors.toList())
				 );
		//op: FlatMap - [S, p, r, i, n, g, S, p, r, i, n, g,  , B, o, o, t, A, P, I, M, i, c, r, o, s, e, r, v, i, c, e, s, A, P, I, A, W, S, P, C, F, A, z, u, r, e, D, o, c, k, e, r, K, u, b, e, r, n, e, t, e, s]

		System.out.println("\nFlatMap distinct - " + courses.stream() 
		       .map(course -> course.split(""))	
		       .flatMap(Arrays :: stream)
		       .distinct()
		       .collect(Collectors.toList())
				);
		//op: FlatMap distinct - [S, p, r, i, n, g,  , B, o, t, A, P, I, M, c, s, e, v, W, C, F, z, u, D, k, K, b]
	
	List<String> courses2 = List.of("Spring", "API" , "AWS", "Docker", "Kubernetes");
	System.out.println("\nflatMap Tuples  - " + courses.stream()
			.flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2)))
			.collect(Collectors.toList())
			);
	//op: flatMap Tuples  - [[Spring, Spring], [Spring, API], [Spring, AWS], [Spring, Docker], [Spring, Kubernetes], [Spring Boot, Spring], [Spring Boot, API], [Spring Boot, AWS], [Spring Boot, Docker], [Spring Boot, Kubernetes], [API, Spring], [API, API], [API, AWS], [API, Docker], [API, Kubernetes], [Microservices, Spring], [Microservices, API], [Microservices, AWS], [Microservices, Docker], [Microservices, Kubernetes], [API, Spring], [API, API], [API, AWS], [API, Docker], [API, Kubernetes], [AWS, Spring], [AWS, API], [AWS, AWS], [AWS, Docker], [AWS, Kubernetes], [PCF, Spring], [PCF, API], [PCF, AWS], [PCF, Docker], [PCF, Kubernetes], [Azure, Spring], [Azure, API], [Azure, AWS], [Azure, Docker], [Azure, Kubernetes], [Docker, Spring], [Docker, API], [Docker, AWS], [Docker, Docker], [Docker, Kubernetes], [Kubernetes, Spring], [Kubernetes, API], [Kubernetes, AWS], [Kubernetes, Docker], [Kubernetes, Kubernetes]]

	System.out.println("\nflatMap: same elements repeated twice - " + courses.stream()
	        .flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2)))
	        .filter(list -> list.get(0).equals(list.get(1)))
	        .collect(Collectors.toList())	        		
			);
//	op: flatMap: same elements repeated twice - [[Spring, Spring], [API, API], [API, API], [AWS, AWS], [Docker, Docker], [Kubernetes, Kubernetes]]

	
	System.out.println("\nflatMap: eliminate same elements repeated twice - " + courses.stream()
    .flatMap(course -> courses2.stream()
    		.map(course2 -> List.of(course, course2)))
    .filter(list -> !list.get(0).equals(list.get(1)))
    .collect(Collectors.toList())	        		
	);
//op: flatMap: eliminate same elements repeated twice - [[Spring, API], [Spring, AWS], [Spring, Docker], [Spring, Kubernetes], [Spring Boot, Spring],
	//[Spring Boot, API], [Spring Boot, AWS], [Spring Boot, Docker], [Spring Boot, Kubernetes], [API, Spring], 
	//[API, AWS], [API, Docker], [API, Kubernetes], [Microservices, Spring], [Microservices, API], [Microservices, AWS], [Microservices, Docker], 
	//[Microservices, Kubernetes], [API, Spring], [API, AWS], [API, Docker], [API, Kubernetes], [AWS, Spring], [AWS, API], [AWS, Docker], [AWS, Kubernetes], 
	//[PCF, Spring], [PCF, API], [PCF, AWS], [PCF, Docker], [PCF, Kubernetes], [Azure, Spring], [Azure, API], [Azure, AWS], [Azure, Docker], [Azure, Kubernetes], 
	//[Docker, Spring], [Docker, API], [Docker, AWS], [Docker, Kubernetes], [Kubernetes, Spring], [Kubernetes, API], [Kubernetes, AWS], [Kubernetes, Docker]]

	System.out.println("\nflatMap: eliminate same elements repeated twice and filter tuples with same length - " + courses.stream()
	.flatMap(course -> courses2.stream()
    		.filter(course2 -> course2.length() == course.length())    //filter tuples with same length
    		.map(course2 -> List.of(course, course2)))
    .filter(list -> !list.get(0).equals(list.get(1)))    //eliminate same elements repeated twice
    .collect(Collectors.toList())
    );
//op: flatMap: filter tuples with same length - [[Spring, Docker], [API, AWS], [API, AWS], [AWS, API], [PCF, API], [PCF, AWS], [Docker, Spring]]

	
	System.out.println("\nkirti's logic-> flatMap: eliminate same elements repeated twice and filter tuples with same length - " + courses.stream()
			.flatMap(course -> courses2.stream()
					.filter(course2 -> !course.equals(course2)     //eliminate same elements repeated twice
					&& course.length()==course2.length())   //filter tuples with same length
					.map(course2 -> List.of(course, course2))
					)
			.collect(Collectors.toList())
			);
	//op: kirti's logic-> flatMap: filter tuples with same length - [[Spring, Docker], [API, AWS], [API, AWS], [AWS, API], [PCF, API], [PCF, AWS], [Docker, Spring]]

	}
}
