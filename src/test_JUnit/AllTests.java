package test_JUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DeckTest.class, HouseTest.class, JailTest.class,
		MoveToJailTest.class, PastStartTest.class, TestPurchase.class })
public class AllTests {

}
