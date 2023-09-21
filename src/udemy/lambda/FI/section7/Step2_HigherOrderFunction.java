package udemy.lambda.FI.section7;

// Step 02 - Creating Higher Order Functions

import java.util.function.Predicate;
import java.util.stream.Collectors;

import udemy.Course;

//Higher Order Function is a function which returns a function
//A higher-order function can be defined as a function that accepts one or more functions as arguments and returns a function as a result.
public class Step2_HigherOrderFunction {

	public static void main(String[] args) {

		Predicate<Course> reviewScoreGreaterThan92predicate = createPredicateWithCutOffReviewScore(92);

		Predicate<Course> reviewScoreGreaterThan95predicate = createPredicateWithCutOffReviewScore(95);

		System.out.println("reviewScoreGreaterThan90predicate: ");
		Course.courseList
		.stream()
		.filter(reviewScoreGreaterThan92predicate)
		.forEach(System.out:: println);
//		op: reviewScoreGreaterThan90predicate: 
//			[Spring, Framework, 98, 20000]
//					[Spring Boot, Framework, 95, 18000]
//					[API, Microservices, 97, 22000]
//					[Microservices, Microservices, 96, 25000]
//					[Azure, Cloud, 99, 21000]

		System.out.println("\nreviewScoreGreaterThan95predicate: "+ Course.courseList.stream()
		.filter(reviewScoreGreaterThan95predicate)
		.collect(Collectors.toList()));
		//op: reviewScoreGreaterThan95predicate: [[Spring, Framework, 98, 20000], [API, Microservices, 97, 22000], [Microservices, Microservices, 96, 25000], [Azure, Cloud, 99, 21000]]

		System.out.println("\nreviewScoreGreaterThan96predicate: "+Course.courseList.stream()
		.filter(createPredicateWithCutOffReviewScore(96))
		.collect(Collectors.toList()));
		//op: reviewScoreGreaterThan96predicate: [[Spring, Framework, 98, 20000], [API, Microservices, 97, 22000], [Azure, Cloud, 99, 21000]]

	}

	//Higher order function which returns a another function
	private static Predicate<Course> createPredicateWithCutOffReviewScore(int cutOffReviewScore) {
		return course -> course.getReviewScore() > cutOffReviewScore;
	}

}
