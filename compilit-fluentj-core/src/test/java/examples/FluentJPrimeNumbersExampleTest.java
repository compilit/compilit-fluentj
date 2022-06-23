package examples;

import org.junit.jupiter.api.Test;
import testutil.AbstractClockingTest;

import java.util.function.Consumer;

import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.LoopOperations.until;
import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.operations.ConnectingOperations.and;
import static com.compilit.fluentj.api.operations.LoggerOperations.print;
import static com.compilit.fluentj.api.operations.LoggerOperations.printIt;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.itIsAPrimeNumber;
import static com.compilit.fluentj.api.predicates.Predicates.andInCaseThat;
import static com.compilit.fluentj.api.predicates.Predicates.itIs;
import static com.compilit.fluentj.api.predicates.Predicates.until;

class FluentJPrimeNumbersExampleTest extends AbstractClockingTest {

  @Test
  void fluentJPrimeNumbers() {
    //while
    startingWith(1,
            until(itIs(10000),
                    keep(adding(1)),
                    and(print("yay")),
                    andInCaseThat(itIsAPrimeNumber(), printIt())));

    //doWhile
    startingWith(1,
            keep(adding(1),
                    until(itIs(10000)),
                    andInCaseThat(itIsAPrimeNumber(), printIt())));

  }

}
