package udemy.lambda.FI.section7;

import java.util.stream.LongStream;

//Step 04 - Improving Performance with Parallelization of Streams

public class Step4_ParallelizationOfStreams {

	public static void main(String[] args) {
		
		long time = System.currentTimeMillis();
		
		//1983 ms
	//	System.out.println(LongStream.range(0, 1000000000).sum());
//		op: 499999999500000000
		
		//139 ms
		System.out.println(LongStream.range(0, 1000000000).parallel().sum());
//		op: 499999999500000000
		
		System.out.println( System.currentTimeMillis() - time);

	}

}
