package examples;

import com.compilit.testtools.AbstractTestTimer;
import org.junit.jupiter.api.Test;

import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.LoopOperations.until;
import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.operations.ConnectingOperations.and;
import static com.compilit.fluentj.api.operations.LoggerOperations.print;
import static com.compilit.fluentj.api.operations.LoggerOperations.printIt;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.itIsAPrimeNumber;
import static com.compilit.fluentj.api.predicates.Predicates.inCaseThat;
import static com.compilit.fluentj.api.predicates.Predicates.itIs;
import static com.compilit.fluentj.api.predicates.Predicates.until;

class FluentJPrimeNumbersExampleTest extends AbstractTestTimer {

  @Test
  void fluentJPrimeNumbers() {
    //while
    startingWith(1,
            until(itIs(10000),
                    keep(adding(1)),
                    and(print("yay")),
                    inCaseThat(itIsAPrimeNumber(), printIt())));

    //doWhile
    startingWith(1,
            keep(adding(1),
                    until(itIs(10000)),
                    inCaseThat(itIsAPrimeNumber(), printIt())));

  }

}
