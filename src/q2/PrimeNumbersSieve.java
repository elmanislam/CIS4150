
import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

public class PrimeNumbersSieve implements Iterable<Integer> {
   private List<Integer> primes = new ArrayList<>();

   public void computePrimes(int n) {
      Boolean[] isPrime = new Boolean[n + 1];

      for (int i = 2; i <= n; i++) {
         isPrime[i] = true;
      }

      for (int factor = 2; factor * factor <= n; factor++) {
         if (isPrime[factor]) {
            for (int j = factor; factor * j <= n; j++) {
               isPrime[factor * j] = false;
            }
         }
      }

      for (int i = 2; i <= n; i++) {
         if (isPrime[i] && (i % 10 != 9)) {
            primes.add(i);
         }
      }
   }

   @Override
   public Iterator<Integer> iterator() {
      return primes.iterator();
   }

   @Override
   public String toString() {
      return primes.toString();
   }

   public static void main(String[] args) {
      System.out.println("Test 1:");
      PrimeNumbersSieve primes1 = new PrimeNumbersSieve();
      primes1.computePrimes(20);
      System.out.println("Prime numbers up to 20: " + primes1);

   }
}
