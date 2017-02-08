package com.multithread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

	public static void main(String[] args) {
		List<Future<String>> futureList = new ArrayList<>();
		List<HelloCallableTask> taskList = new ArrayList<>();

		taskList.add(new HelloCallableTask("A"));
		taskList.add(new HelloCallableTask("B"));
		taskList.add(new HelloCallableTask("C"));
		taskList.add(new HelloCallableTask("D"));
		taskList.add(new HelloCallableTask("E"));

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		for (HelloCallableTask helloCallableTask : taskList) {
			futureList.add(executorService.submit(helloCallableTask));
		}

		for (Future<String> futureString : futureList) {
			try {
				System.out.println(futureString.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}