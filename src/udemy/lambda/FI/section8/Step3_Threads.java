package udemy.lambda.FI.section8;

import java.util.stream.IntStream;

//Step 3- Playing with Threads using Functional Programming

public class Step3_Threads {

	public static void main(String[] args) {

		Runnable runnable = new Runnable() {			
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.println(Thread.currentThread().getId() + ":" + i);
				}				
			}
		};

		//Functional approach
		Runnable runnableFunctional = () -> {
			for(int i=0; i<10; i++) {
				System.out.println("Functional Approach-> " + Thread.currentThread().getName() + " :" + i);
			}
			
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
		
		Thread thread1 = new Thread(runnable);
		thread1.start();
		
		Thread kirtithread = new Thread(runnableFunctional);
		kirtithread.start();

		//Here, we have eliminated the for loop
		Runnable runnableObj = () -> {
			IntStream.range(0, 100)
			.forEach( i -> System.out.println("Eliminate the loop-> " + Thread.currentThread().getId() + ":" + i));
		};
		
		Thread threadRunnableObj = new Thread(runnableObj);
		threadRunnableObj.run();
	}

}
