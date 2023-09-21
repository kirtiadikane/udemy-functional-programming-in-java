package udemy;

import java.util.List;

public class Course{

	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the reviewScore
	 */
	public int getReviewScore() {
		return reviewScore;
	}
	/**
	 * @param reviewScore the reviewScore to set
	 */
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	/**
	 * @return the noOfStudents
	 */
	public int getNoOfStudents() {
		return noOfStudents;
	}
	/**
	 * @param noOfStudents the noOfStudents to set
	 */
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	@Override
	public String toString() {
		return "[" + name + ", " + category + ", " + reviewScore + ", "+ noOfStudents + "]";
	}

	//This list is used in other classes
	public static List<Course> courseList = List.of(
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


}
