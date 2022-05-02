package examples;

import org.junit.jupiter.api.Test;
import testutil.AbstractClockingTest;

import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.LoopOperations.untilReachingOrGoingAbove;
import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.operations.LoggerOperations.printIt;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.itIsAPrimeNumber;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.untilReachingOrGoingAbove;
import static com.compilit.fluentj.api.predicates.Predicates.andInCaseThat;

class FluentJPrimeNumbersExampleTest extends AbstractClockingTest {

  @Test
  void fluentJPrimeNumbers() {
    //while
    //if-statement consumer visually a part of the loop
    startingWith(1,
            untilReachingOrGoingAbove(10000,
            keep(adding(1)), andInCaseThat(itIsAPrimeNumber(), printIt())));

    //while
    startingWith(1,
            untilReachingOrGoingAbove(10000, keep(adding(1))),
            andInCaseThat(itIsAPrimeNumber(), printIt()));

    //doWhile
    startingWith(1,
            keep(adding(1), untilReachingOrGoingAbove(10000)),
            andInCaseThat(itIsAPrimeNumber(), printIt()));

  }

}
