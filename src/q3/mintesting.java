import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MinTest<T extends Comparable<? super T>> {

    private List<T> list;                // The list of input values (either Integer or String)
    private T expectedResult;            // The expected minimum value or null if an error is expected
    private Class<? extends Throwable> expectedException; // The expected exception class, or null if no exception

    // Constructor for the parameterized test cases
    public MinTest(List<T> list, T expectedResult, Class<? extends Throwable> expectedException) {
        this.list = list;
        this.expectedResult = expectedResult;
        this.expectedException = expectedException;
    }

    // This method provides the test data (with passes, failures, and errors)
    @Parameterized.Parameters
    public static Collection<Object[]> provideTestData() {
        return Arrays.asList(new Object[][]{
            // Integer test cases

            {Arrays.asList(3, 1, 4, 1, 5, 9), 1, null}, // Test Case 1: Normal integer list, expected minimum = 1 (Pass)
            {Arrays.asList(7), 7, null}, // Test Case 2: Single element list, expected minimum = 7 (Pass)
            {Arrays.asList(9, 5, 0, -10), -10, null}, // Test Case 3: Integer list in reverse order, expected minimum = -10 (Pass)
            {Arrays.asList(), null, IllegalArgumentException.class}, // Test Case 4: Empty list, expected to throw IllegalArgumentException (Error)
            {Arrays.asList(5, null, 2), null, NullPointerException.class}, // Test Case 5: List with null element, expected to throw NullPointerException (Error)
            {Arrays.asList(3, 1, 4), 2, null}, // Test Case 6: Incorrect expected value (2 instead of 1), expected to fail (Failure)

            // String test cases

            {Arrays.asList("brad", "adam", "chris"), "adam", null}, // Test Case 7: Normal string list, expected minimum = "adam" (Pass)
            {Arrays.asList("zach"), "zach", null}, // Test Case 8: Single string element, expected minimum = "zach" (Pass)
            {Arrays.asList(), null, IllegalArgumentException.class}, // Test Case 9: Empty string list, expected to throw IllegalArgumentException (Error)
            {Arrays.asList("brad", "adam", "chris"), "brad", null} // Test Case 10: Incorrect expected value ("banana" instead of "apple"), expected to fail (Failure)
        });
    }

    // The test method for Min.min with both Integer and String data
    @Test
    public void testMinFunction() {
        if (expectedException != null) {
            // Test is expected to throw an exception
            try {
                Min.min(list); // Call the method to test
                fail("Expected exception: " + expectedException.getName()); // Fail if no exception is thrown
            } catch (Throwable ex) {
                // Check if the correct exception is thrown
                assertTrue(expectedException.isInstance(ex)); // Verify the type of exception thrown matches the expected exception
            }
        } else {
            // Test is expected to pass normally
            assertEquals(expectedResult, Min.min(list)); // Check if the expected result matches the actual result from Min.min
        }
    }
}
