package concurrency.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class CallableFutureExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<Future<Integer>> list = new ArrayList<>();
		
		ThreadPoolExecutor tpExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		for(int i=0;i<4000;i++){
			int num = new Random().nextInt(10);
			Future<Integer> results = tpExecutor.submit( new FactorialCalculator(num));
			list.add(results);
		}
		
		for(Future<Integer> future: list) {
			System.out.println("Future: "+future.get());
		}
		
		tpExecutor.shutdown();
	}
}

class FactorialCalculator implements Callable<Integer>{

		Integer number;
		
		public FactorialCalculator(Integer num) {
			number = num;
		}
	
		@Override
	public Integer call() throws Exception {
		int factorial = 1;
		
		if(number ==0 || number == 1)
			;
		if(number<0)
			return -1;
		for(int i=number;i>1;i--)
			factorial *= i;
		System.out.println("Factorial of "+number+" is: "+factorial);
		return factorial;
	}
	
}