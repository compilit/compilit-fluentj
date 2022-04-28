package examples;

import testutil.AbstractClockingTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.compilit.fluentj.api.operations.LoggerOperations.printIt;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.LoopOperations.untilReachingOrGoingAbove;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.untilReachingOrGoingAbove;
import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.predicates.Predicates.andInCaseThat;
import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.itIsAPrimeNumber;

class FluentJPrimeNumbersExampleTest extends AbstractClockingTest {

  @Test
  void fluentJPrimeNumbers() {
    //while
    startingWith(1,
            untilReachingOrGoingAbove(10000, keep(adding(1))),
            andInCaseThat(itIsAPrimeNumber(), printIt()));

    //doWhile
    startingWith(1,
            keep(adding(1), untilReachingOrGoingAbove(10000)),
            andInCaseThat(itIsAPrimeNumber(), printIt()));
  }

  @Test
  void tst() {
    Assertions.assertThat(itIsAPrimeNumber()).rejects(4);
  }

}
