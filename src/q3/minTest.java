import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MinTest {

    private List<?> list;                // The list of input values (either Integer or String)
    private Object expectedResult;       // The expected minimum value or null if an error is expected
    private Class<? extends Throwable> expectedException; // The expected exception class, or null if no exception

    // Constructor for the parameterized test cases
    public MinTest(List<?> list, Object expectedResult, Class<? extends Throwable> expectedException) {
        this.list = list;
        this.expectedResult = expectedResult;
        this.expectedException = expectedException;
    }

    // This is the method that provides the test data (with passes, failures, and errors)
    @Parameterized.Parameters
    public static Collection<Object[]> provideTestData() {
        return Arrays.asList(new Object[][]{
            // Integer test cases

            // Case 1: Normal integer list, expected to pass, min = 1
            {Arrays.asList(3, 1, 4, 1, 5, 9), 1, null}, // Pass

            // Case 2: Integer list with a single element, expected to pass, min = 7
            {Arrays.asList(7), 7, null}, // Pass

            // Case 3: Integer list in reverse order, expected to pass, min = -10
            {Arrays.asList(9, 5, 0, -10), -10, null}, // Pass

            // Case 4: Empty integer list, expected to throw IllegalArgumentException
            {Arrays.asList(), null, IllegalArgumentException.class}, // Error

            // Case 5: Integer list with null elements, expected to throw NullPointerException
            {Arrays.asList(5, null, 2), null, NullPointerException.class}, // Error

            // Case 6: Integer list where expected value is wrong (expected failure), min is 1, but we expect 2
            {Arrays.asList(3, 1, 4), 2, null}, // Failure

            // String test cases

            // Case 7: Normal string list, expected to pass, min = "apple"
            {Arrays.asList("banana", "apple", "cherry"), "apple", null}, // Pass

            // Case 8: String list with a single element, expected to pass, min = "zebra"
            {Arrays.asList("zebra"), "zebra", null}, // Pass

            // Case 9: Empty string list, expected to throw IllegalArgumentException
            {Arrays.asList(), null, IllegalArgumentException.class}, // Error

            // Case 10: String list where expected value is wrong (expected failure), min is "apple", but we expect "banana"
            {Arrays.asList("banana", "apple", "cherry"), "banana", null} // Failure
        });
    }

    // The test method for Min.min with both Integer and String data
    @Test
    public void testMinFunction() {
        if (expectedException != null) {
            // Test is expected to throw an exception
            try {
                Min.min(list);
                fail("Expected exception: " + expectedException.getName()); // Fail if no exception is thrown
            } catch (Throwable ex) {
                assertTrue(expectedException.isInstance(ex)); // Check if the correct exception is thrown
            }
        } else {
            // Test is expected to pass normally
            assertEquals(expectedResult, Min.min(list)); // Check if the expected result matches the actual result
        }
    }
}
