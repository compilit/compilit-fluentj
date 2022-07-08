package examples;

import com.compilit.testtools.AbstractTestTimer;
import org.junit.jupiter.api.Test;

class RegularPrimeNumbersExampleTest extends AbstractTestTimer {

  @Test
  void regularJavaPrimeNumbers() {
    for (int possiblePrime = 1; possiblePrime < 10000; possiblePrime++) {
      if (isAPrimeNumber(possiblePrime)) {
        System.out.println(possiblePrime);
      }
    }

  }

  private boolean isAPrimeNumber(int possiblePrime) {
    for (int divisor = 2; divisor < possiblePrime; divisor++) {
      if (possiblePrime % divisor == 0)
        return false;
    }
    return true;
  }

}
