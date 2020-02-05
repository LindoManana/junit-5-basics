# JUnit 5
This is a simple maven project that shows the basic usage of JUnit 5 for unit testing. 

### Overview
 JUnit is one of the most popular unit-testing frameworks in the Java ecosystem. The JUnit 5 version contains a number of exciting innovations, with the goal to support new features in Java 8 and above, as well as enabling many different styles of testing.

### Features
This project takes a quick look at the following JUnit 5 basic concepts:
1. **Basic annotations:**
 - **@BeforeAll:** executes once before all test methods in the test class.
- **@BeforeEach:** executes before each test method in the test class.
- **@AfterEach:** executed after each test method.
- **@AfterAll:** executed after all test methods.
- **@DisplayName:** change display name of test method.
- **@Disabled:** disable the test method.
- **@Test:** used to mark a method as a junit test.
- **@Nested:** used to create nested test classes.
- **@RepeatedTest:** repeats test several times.


***NB:** It's important to note that the method with **@BeforeAll** annotation needs to be static, otherwise the code will not compile.*

2. **Assertions and Assumptions**
- **@assumeTrue:** validates the given assumption to true and if assumption is true – test proceed,                  otherwise test execution is aborted.
- **@assertEquals**

3. **Exception Testing**
- **@assertThrows:** it asserts that execution of the supplied executable throws an exception of the expectedType and returns the exception.

## Built With

* [JUnit 5](https://junit.org/junit5/) - Unit-testing framework used
* [Maven](https://maven.apache.org/) - Dependency Management