/*
 * 
 * Author: Elman I.
 * Email: elmanislam123@gmail.com
 * 
 * Creation Date: 2024-10-14 21:13:25
 Last Modification Date: 2024-10-15 16:01:49
 * 
 */

package q1;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeNumbersTest {

   /* (a) A test that does not reach the fault */
   @Test
   public void testWithZeroInput() {
      PrimeNumbers primeNumbers = new PrimeNumbers();
      primeNumbers.computePrimes(0);

      assertEquals("[]", primeNumbers.toString());
      // it never enters the while loop
   }

   /* (b) A test that reaches the fault, but does not infect */
   @Test
   public void testWithoutInfecting() {
      PrimeNumbers primeNumbers = new PrimeNumbers();
      primeNumbers.computePrimes(7);

      assertEquals("[2, 3, 5, 7, 11, 13, 17]", primeNumbers.toString());
      // The code where the fault exists is reached. However, it is never 'infected'
      // As the condition to infect does not activate, due to the first prime number
      // ending with a 9 not being reached (i.e. '19').
   }

   /* (c) A test that infects the state, but does not propagate */
   @Test
   public void testInfectionWithoutPropagation() {
      PrimeNumbers primeNumbers = new PrimeNumbers();
      primeNumbers.computePrimes(8);

      assertEquals("[2, 3, 5, 7, 11, 13, 17, 19]",
            primeNumbers.toString());
   }

   /* (e) A test that reveals the fault */
   @Test
   public void revealFault() {
      PrimeNumbers primeNumbers = new PrimeNumbers();
      primeNumbers.computePrimes(8);

      assertEquals("[2, 3, 5, 7, 11, 13, 17, 19]", primeNumbers.toString());
      // The code where the fault exists is reached. A fault is revealed as 19 should
      // be present in the output, but is not received.
   }
}