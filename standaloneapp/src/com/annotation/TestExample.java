package com.annotation;

import com.annotation.TesterInfo.Priority;

@TesterInfo(priority = Priority.HIGH, createdBy = "Shailendra Sharma", tags = "{sapient, test}")
public class TestExample {

	@Test(enable = false)
	public void testA() {
		if (true) {
			System.out.println("true value entered");
		}
	}

	@Test
	void testB() {
		if (false)
			throw new RuntimeException("This test always passed");
	}

	@Test(enable = true)
	void testC() {
		if (10 > 1) {
			// do nothing, this test always passed.
		}
	}
}
