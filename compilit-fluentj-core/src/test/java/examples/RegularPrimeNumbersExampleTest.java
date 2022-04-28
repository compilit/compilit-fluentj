package examples;

import testutil.AbstractClockingTest;
import org.junit.jupiter.api.Test;

class RegularPrimeNumbersExampleTest extends AbstractClockingTest {

  @Test
  void regularJavaPrimeNumbers() {
    for (int possiblePrime = 1; possiblePrime < 10000; possiblePrime++) {
      if (isAPrime(possiblePrime)) {
        System.out.println(possiblePrime);
      }
    }
  }

  private boolean isAPrime(int possiblePrime) {
    return possiblePrime == 1
            || itIsNotDivisibleByOtherNumbers(possiblePrime);
  }

  private boolean itIsNotDivisibleByOtherNumbers(int possiblePrime) {
    for (int divisor = 2; divisor < possiblePrime / 2; divisor++) {
      if (possiblePrime % divisor == 0)
        return false;
    }
    return true;
  }

}
