package com.sapient.batchinstallerseq.test;

import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import com.sapient.batchinstallerseq.app.App;

/**
 * Unit test for InstallerSeq App.
 */
public class AppTest {

	/**
	 * can be modified later for bigger and complex inputs
	 */
	@Test
	public void testSinglePossibleSeqCase1() {
		Integer[][] dependecyGraph = new Integer[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } };
		List<Integer> expectedList = Arrays.asList(4, 3, 2, 1);
		// calling user api
		List<Integer> retList = App.returnInstallationSequence(dependecyGraph);
		Assert.assertEquals(expectedList, retList);
	}

	/**
	 * can be modified later for bigger and complex inputs,Re arranged case 1
	 * inputs
	 */
	@Test
	public void testSinglePossibleSeqCase2() {
		Integer[][] dependecyGraph = new Integer[][] { { 3, 4 }, { 2, 3 }, { 1, 2 } };
		List<Integer> expectedList = Arrays.asList(4, 3, 2, 1);
		// calling user api
		List<Integer> retList = App.returnInstallationSequence(dependecyGraph);
		Assert.assertEquals(expectedList, retList);
	}

	/**
	 * can be modified later for bigger and complex inputs
	 */
	@Test
	public void testMultiplePossibleSeqCase1() {
		Integer[][] dependecyGraph = new Integer[][] { { 1, 3 }, { 2, 3 }, { 3, 4 } };
		List<Integer> expectedList1 = Arrays.asList(4, 3, 2, 1);
		List<Integer> expectedList2 = Arrays.asList(4, 3, 1, 2);
		// calling user api
		List<Integer> retList = App.returnInstallationSequence(dependecyGraph);
		if (!((expectedList1.equals(retList)) || (expectedList2.equals(retList)))) {
			assertTrue(false);
		}
	}

	/**
	 * can be modified later for bigger and complex inputs, Re arranged case 1
	 * inputs
	 */
	@Test
	public void testMultiplePossibleSeqCase2() {
		Integer[][] dependecyGraph = new Integer[][] { { 2, 3 }, { 1, 3 }, { 3, 4 } };
		List<Integer> expectedList1 = Arrays.asList(4, 3, 2, 1);
		List<Integer> expectedList2 = Arrays.asList(4, 3, 1, 2);
		// calling user api
		List<Integer> retList = App.returnInstallationSequence(dependecyGraph);
		if (!((expectedList1.equals(retList)) || (expectedList2.equals(retList)))) {
			assertTrue(false);
		}
	}

	/**
	 * can be modified later for bigger and complex inputs
	 */
	@Test
	public void testDependencyCycleCase1() {
		Integer[][] dependencyGraph = new Integer[][] { { 1, 2 }, { 2, 3 }, { 3, 1 } };
		// calling user api
		List<Integer> retList = App.returnInstallationSequence(dependencyGraph);
		if (!(null == retList || retList.isEmpty())) {
			assertTrue(false);
		}
	}

	/**
	 * can be modified later for bigger and complex inputs,Re arranged case 1
	 * inputs
	 */
	@Test
	public void testDependencyCycleCase2() {
		Integer[][] dependencyGraph = new Integer[][] { { 3, 1 }, { 1, 2 }, { 2, 3 } };
		// calling user api
		List<Integer> retList = App.returnInstallationSequence(dependencyGraph);
		if (!(null == retList || retList.isEmpty())) {
			assertTrue(false);
		}
	}
}
