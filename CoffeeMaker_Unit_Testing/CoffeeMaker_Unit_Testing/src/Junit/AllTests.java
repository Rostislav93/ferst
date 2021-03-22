package Junit;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(MoneyBagTest.class);
		suite.addTestSuite(MoneyTest.class);
		//$JUnit-END$
		return suite;
	}

}
