import javax.swing.text.html.HTMLDocument.Iterator;

public class App {
   public static void main(String[] args) throws Exception {
      PrimeNumbers primeNumbers = new PrimeNumbers();
      primeNumbers.computePrimes(12);
      int primes = primeNumbers.iterator()
      System.out.println(primeNumbers.toString());

   }
}