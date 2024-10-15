import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import q1.PrimeNumbers;
import q2.PrimeNumbers2;

public class App {
   public static void main(String[] args) throws Exception {
      PrimeNumbers primeNumbers = new PrimeNumbers();
      primeNumbers.computePrimes(12);
      Iterator<Integer> itr = primeNumbers.iterator();
      System.out.println(primeNumbers.toString());

   }
}
