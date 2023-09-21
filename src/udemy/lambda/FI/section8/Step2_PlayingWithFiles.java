package udemy.lambda.FI.section8;

//Step 2 - Playing with Files using Functional Programming

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Step2_PlayingWithFiles {

	public static void main(String[] args) throws IOException {
		
		Files.lines(Paths.get("src\\udemy\\lambda\\FI\\section8\\DummyFile.txt")) //read the line
		.forEach(System.out::println);

		System.out.println("\n******************************");
		
		//print unique words from the file
		Files.lines(Paths.get("src\\udemy\\lambda\\FI\\section8\\DummyFile.txt"))
		.map(str -> str.split(" "))
		.flatMap(Arrays :: stream)
		.distinct()
		.sorted()
		.forEach(System.out :: println);
		//op: 
//		
//		:)
//		;)
//		DUMMY
//		From
//		Hello,
//		I
//		Step2_PlayingWithFiles
//		Thanks
//		Used
//		am
//		and
//		class
//		dummy
//		file
//		file.
//		in
//		package
//		udemy.lambda.FI.section8
		
		/* In above
		 * Special characters printed first, then Uppercase, lowercase
		 */

		System.out.println("\n****************************** \nList all the files and folders present in the root folder: ");
		
		Files.list(Paths.get(""))
		.forEach(System.out:: println);
		//op: List all the files and folders present in the root folder: 
//		.classpath
//		.project
//		.settings
//		bin
//		src
		
		
		System.out.println("\n****************************** \nList only the folders/directories present in the root folder: ");
		Files.list(Paths.get(""))
		.filter(Files :: isDirectory)
		.forEach(System.out::println);
//		op: List only the folders/directories present in the root folder: 
//			.settings
//			bin
//			src
	}

}
