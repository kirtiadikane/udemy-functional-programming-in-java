package udemy.lambda.FI.section5;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import udemy.Course;



public class CustomClasses {

	public static void main(String[] args) {
		List<Course> courseList = List.of(
				new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), 
				new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), 
				new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), 
				new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000)
				);

		/**
		 * allMatch
		 */
		Predicate<Course> reviewScoreGreaterThan90predicate = course -> course.getReviewScore() > 90;
		System.out.println(courseList.stream().allMatch(reviewScoreGreaterThan90predicate));

		Predicate<Course> reviewScoreGreaterThan95predicate = course -> course.getReviewScore() > 95;  //true
		/**
		 * noneMatch
		 */
		System.out.println(courseList.stream().noneMatch(reviewScoreGreaterThan95predicate));  //false

		/**
		 * anyMatch
		 */
		System.out.println(courseList.stream().anyMatch(reviewScoreGreaterThan95predicate));  //true

		Predicate<Course> reviewScoreLessThan90predicate = course -> course.getReviewScore() < 90;
		System.out.println(courseList.stream().anyMatch(reviewScoreLessThan90predicate));  //false


		/**
		 * Comparator
		 */
		Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparing(Course :: getNoOfStudents);
		System.out.println("comparingByNoOfStudentsIncreasing: " + courseList.stream()
		.sorted(comparingByNoOfStudentsIncreasing)
		.collect(Collectors.toList()));
		//comparingByNoOfStudentsIncreasing: [[FullStack, FullStack, 91, 14000], [Spring Boot, Framework, 95, 18000], [Spring, Framework, 98, 20000], [Docker, Cloud, 92, 20000], [Kubernetes, Cloud, 91, 20000], [AWS, Cloud, 92, 21000], [Azure, Cloud, 99, 21000], [API, Microservices, 97, 22000], [Microservices, Microservices, 96, 25000]]

		/**
		 * Comparator.comparingInt()
		since getNoOfStudents is primitive data type then it is efficient to use comparingInt() instead of comparing
		By doing so, it skips the unboxing
		 */
		Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparingInt(Course :: getNoOfStudents).reversed();
		System.out.println("comparingByNoOfStudentsDecreasing: " + courseList.stream()
		.sorted(comparingByNoOfStudentsDecreasing)
		.collect(Collectors.toList()));
		//comparingByNoOfStudentsDecreasing: [[Microservices, Microservices, 96, 25000], [API, Microservices, 97, 22000], [AWS, Cloud, 92, 21000], [Azure, Cloud, 99, 21000], [Spring, Framework, 98, 20000], [Docker, Cloud, 92, 20000], [Kubernetes, Cloud, 91, 20000], [Spring Boot, Framework, 95, 18000], [FullStack, FullStack, 91, 14000]]

		/**
		 * thenComparingInt()
		 */
		Comparator<Course> comparingByNoOfStudentAndReviewScore = Comparator.comparingInt(Course:: getNoOfStudents)
				.thenComparingInt(Course::getReviewScore).reversed();
		System.out.println("\ncomparingByNoOfStudentAndReviewScore: " + 
				courseList.stream()
		.sorted(comparingByNoOfStudentAndReviewScore)
		.collect(Collectors.toList()));
		//comparingByNoOfStudentAndReviewScore: [[Microservices, Microservices, 96, 25000], [API, Microservices, 97, 22000], [Azure, Cloud, 99, 21000], [AWS, Cloud, 92, 21000], [Spring, Framework, 98, 20000], [Docker, Cloud, 92, 20000], [Kubernetes, Cloud, 91, 20000], [Spring Boot, Framework, 95, 18000], [FullStack, FullStack, 91, 14000]]

		/**
		 * limit
		 */
		System.out.println("\ncomparingByNoOfStudentAndReviewScore limit: " + 
				courseList.stream()
		.sorted(comparingByNoOfStudentAndReviewScore)
		.limit(3)
		.collect(Collectors.toList()));
		//comparingByNoOfStudentAndReviewScore limit: [[Microservices, Microservices, 96, 25000], [API, Microservices, 97, 22000], [Azure, Cloud, 99, 21000]]


		/**
		 * skip
		 */
		System.out.println("\ncomparingByNoOfStudentAndReviewScore skip: " + 
				courseList.stream()
		.sorted(comparingByNoOfStudentAndReviewScore)
		.skip(7)
		.collect(Collectors.toList()));
		//comparingByNoOfStudentAndReviewScore skip: [[Spring Boot, Framework, 95, 18000], [FullStack, FullStack, 91, 14000]]


		/**
		 * limit and skip
		 */
		System.out.println("\ncomparingByNoOfStudentAndReviewScore skip and limit: " + 
				courseList.stream()
		.sorted(comparingByNoOfStudentAndReviewScore)
		.skip(5)
		.limit(2)
		.collect(Collectors.toList()));
		//comparingByNoOfStudentAndReviewScore skip and limit: [[Docker, Cloud, 92, 20000], [Kubernetes, Cloud, 91, 20000]]


		/**
		 * takeWhile
		 */
		System.out.println("\ntakeWhile: " +
				courseList.stream()
		.takeWhile(course -> course.getNoOfStudents() < 22000)
		.collect(Collectors.toList()));
		//takeWhile: [[Spring, Framework, 98, 20000], [Spring Boot, Framework, 95, 18000]]

		/**
		 * dropWhile
		 */
		System.out.println("\ndropWhile: " +
				courseList.stream()
		.dropWhile(course -> course.getNoOfStudents() < 23000 )
		.collect(Collectors.toList()));
		//dropWhile: [[Microservices, Microservices, 96, 25000], [FullStack, FullStack, 91, 14000], [AWS, Cloud, 92, 21000], [Azure, Cloud, 99, 21000], [Docker, Cloud, 92, 20000], [Kubernetes, Cloud, 91, 20000]]

		/**
		 * Comparator - max
		 */
		System.out.println("\nmax: " +
				courseList.stream()
		.max(comparingByNoOfStudentAndReviewScore));
		//max: Optional[[FullStack, FullStack, 91, 14000]]

		/**
		 * Comparator - min
		 */
		System.out.println("\n1. min: " +
				courseList.stream()
		.min(comparingByNoOfStudentAndReviewScore));
		//min: Optional[[Microservices, Microservices, 96, 25000]]

		System.out.println("\n2. min: " +
				courseList.stream()
		.min(comparingByNoOfStudentAndReviewScore)
		.orElse(new Course("dummy","dummy",0,0)));
		//min: [[Microservices, Microservices, 96, 25000]]

		/**
		 * Comparator - min and filter
		 */
		System.out.println("\nmin and filter: " +
				courseList.stream()
		.filter(reviewScoreLessThan90predicate)
		.min(comparingByNoOfStudentAndReviewScore) );
		//min and filter: Optional.empty

		System.out.println("\nmin and filter: " +
				courseList.stream()
		.filter(reviewScoreLessThan90predicate)
		.min(comparingByNoOfStudentAndReviewScore)
		.orElse(new Course("KirtiCourse","KirtiCatgeory",9,10)));
		//min and filter: [KirtiCourse, KirtiCatgeory, 9, 10]

		/**
		 * findFirst
		 */
		System.out.println("\n1. findFirst: " +
				courseList.stream()
		.filter(reviewScoreLessThan90predicate)
		.findFirst() );
		//1. findFirst: Optional.empty

		System.out.println("\n2. findFirst: " +
				courseList.stream()
		.filter(reviewScoreGreaterThan90predicate)
		.findFirst() );
		//2. findFirst: Optional[[Spring, Framework, 98, 20000]]

		/**
		 * findAny
		 */
		System.out.println("\nfindAny: " +
				courseList.stream()
		.filter(reviewScoreGreaterThan90predicate)
		.findAny() );
		//findAny: Optional[[Spring, Framework, 98, 20000]]

		/**
		 * mapToInt() count()
		 */
		System.out.println("\ncount: " +
				courseList.stream()
		.filter(reviewScoreGreaterThan95predicate)
		.mapToInt(Course::getNoOfStudents)
		.count()
				);
		//count: 4

		/**
		 * mapToInt() sum()
		 */
		System.out.println("\nsum: " +
				courseList.stream()
		.filter(reviewScoreGreaterThan95predicate)
		.mapToDouble(Course::getNoOfStudents)
		.sum()  
		+ " | sum: "+ 
		courseList.stream()
		.filter(reviewScoreGreaterThan95predicate)
		.mapToInt(Course::getNoOfStudents)
		.sum());
		//sum: 88000.0 | sum: 88000

		/**
		 * mapToInt() average()
		 */
		System.out.println("\naverage: " +
				courseList.stream()
		.filter(reviewScoreGreaterThan95predicate)
		.mapToInt(Course::getNoOfStudents)
		.average() );
		//average: OptionalDouble[22000.0]

		/**
		 * mapToInt() max():
		 */
		System.out.println("\nmapToInt() max(): " +
				courseList.stream()
		.filter(reviewScoreGreaterThan95predicate)
		.mapToInt(Course::getNoOfStudents)
		.max() );
		//mapToInt() max(): OptionalInt[25000]

		/**
		 * mapToInt() min():
		 */
		System.out.println("\nmapToInt() min(): " +
				courseList.stream()
		.filter(reviewScoreGreaterThan95predicate)
		.mapToInt(Course::getNoOfStudents)
		.min() );
		//mapToInt() min(): OptionalInt[20000]

		/**
		 * Collectors.groupingBy():
		 */
		//return the course by category wise
		System.out.println("\nCollectors.groupingBy course category: " +
				courseList.stream()
		.collect(Collectors.groupingBy(Course::getCategory)) );
		//      Collectors.groupingBy(): {Cloud=[[AWS, Cloud, 92, 21000], [Azure, Cloud, 99, 21000], [Docker, Cloud, 92, 20000], [Kubernetes, Cloud, 91, 20000]], 
		//		FullStack=[[FullStack, FullStack, 91, 14000]], 
		//		Microservices=[[API, Microservices, 97, 22000], [Microservices, Microservices, 96, 25000]], 
		//		Framework=[[Spring, Framework, 98, 20000], [Spring Boot, Framework, 95, 18000]]}

		/**
		 * Collectors.groupingBy() counting
		 */
		//count the course by category
		System.out.println("\nCollectors.groupingBy course category counting: " +
				courseList.stream()
		.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()) ) );
		//Collectors.groupingBy course category counting: {Cloud=4, FullStack=1, Microservices=2, Framework=2}


		/**
		 * Collectors.groupingBy() maxBy
		 */
		//return the course by category wise with the highest score review
		System.out.println("\nCollectors.groupingBy course by category with the highest score review : " +
				courseList.stream()
		.collect(Collectors.groupingBy(Course::getCategory, 
				Collectors.maxBy(Comparator.comparingInt(Course:: getReviewScore)) ) ) );
		//Collectors.groupingBy course category and its highest review : 
		//		{Cloud=Optional[[Azure, Cloud, 99, 21000]], 
		//				FullStack=Optional[[FullStack, FullStack, 91, 14000]], 
		//				Microservices=Optional[[API, Microservices, 97, 22000]], 
		//				Framework=Optional[[Spring, Framework, 98, 20000]]}

		/**
		 * Collectors.groupingBy() maxBy
		 */
		//return the course name list by category wise 
		Map<String, List<String>> courseNameByCategoryWise = courseList.stream()
				.collect(Collectors.groupingBy(Course::getCategory,
						Collectors.mapping(Course::getName, Collectors.toList()) ));

		System.out.println("\nCollectors.groupingBy course name list by category wise  : " +
				courseNameByCategoryWise);
		//		Collectors.groupingBy course name list by category wise  : 
		//		{Cloud=[AWS, Azure, Docker, Kubernetes], 
		//		FullStack=[FullStack], 
		//		Microservices=[API, Microservices], 
		//		Framework=[Spring, Spring Boot]}


	}

}
