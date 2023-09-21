package udemy.lambda.stream;

import java.util.List;
import java.util.stream.Collectors;

public class FP3collectCollectors {

	public static void main(String[] args) {
			
		List<Integer> numbers = List.of(2,5,9,2,3,9);
		
		List<Integer> doubleList= squareOfNum(numbers);
        System.out.println(doubleList);

   }

	private static List<Integer> squareOfNum(List<Integer> numList) {
		return numList.stream()
				.map(num -> num*num)
				.collect(Collectors.toList());
	}
	
}
