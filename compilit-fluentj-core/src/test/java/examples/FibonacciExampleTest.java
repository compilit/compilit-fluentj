package examples;

import org.junit.jupiter.api.Test;

import static com.compilit.fluentj.api.arithmetic.Addition.addingThePreviousValueToIt;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.operations.ConnectingOperations.and;
import static com.compilit.fluentj.api.operations.LoggerOperations.printIt;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.itIsGreaterThan;
import static com.compilit.fluentj.api.predicates.Predicates.until;

class FibonacciExampleTest {
  @Test
  void fluentJFibonacci() {
    startingWith(1,
            keep(addingThePreviousValueToIt(), until(itIsGreaterThan(1000)),
                    and(printIt())));
  }

}
