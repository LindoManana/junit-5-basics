package io.javatricks.utils;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MathUtilsTest {
	MathUtils mathUtil;
	TestInfo testInfo;

	@BeforeAll
	static void setup() {
		System.out.println("@BeforeAll - executes before the test class is initiated...");
	}

	@BeforeEach
	void init(TestInfo testInfo) {
		System.out.println("@BeforeEach - executes before each test case is ran...");
		this.testInfo = testInfo;

		mathUtil = new MathUtils();
	}

	@AfterEach
	void cleanUp() {
		System.out.println("@AfterEach - executes after each test case is ran...");
	}

	@AfterAll
	static void done() {
		System.out.println("@AfterAll - executed after all test methods.");
	}

	@Test
	@DisplayName("Testing addition method")
	void testAdd() {

		int expected = 3;
		int actual = mathUtil.add(1, 2);

		assertEquals(expected, actual, "The add method should add two numbers");
	}

	@Test
	void testAssume() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);

		System.out.println("testAssume - Print this statement if assume is true...");
	}

	@Test
	@Disabled
	@DisplayName("TDD method. Should not run.")
	void testDisabled() {
		fail("This test should be disabled.");
	}

	@Test
	@DisplayName("Test multiplication")
	void testMultiply() {
		System.out.println("Running test ==> " + testInfo.getDisplayName());
		assertAll(() -> assertEquals(0, mathUtil.multiply(1, 0)), () -> assertEquals(1, mathUtil.multiply(1, 1)),
				() -> assertEquals(6, mathUtil.multiply(2, 3)));
	}

	@Nested
	class testNestedAdd {
		@Test
		void testAddingTwoPositives() {
			assertEquals(2, mathUtil.add(1, 1), "Add method should return the sum of two numbers");
		}

		@Test
		void testAddingTwoNegatives() {
			assertEquals(-2, mathUtil.add(-1, -1), "Add method should return the sum of two numbers");
		}

		@Test
		void testAddingAPositiveAndANegative() {
			assertEquals(0, mathUtil.add(-1, 1), "Add method should return the sum of two numbers");
		}
	}

	@Test
	@EnabledOnOs(OS.LINUX)
	void testDivide() {

		assertThrows(NullPointerException.class, () -> mathUtil.divide(5, 0),
				"Divide by zero should throw ArithmeticException");
	}

	@RepeatedTest(3)
	void testComputeCircleArea(RepetitionInfo info) {
		System.out.println("@RepeatedTest ==> " + info.getCurrentRepetition());
		assertEquals(314.1592653589793, mathUtil.computeCircleArea(10), "Should return right circle area");
	}

}
