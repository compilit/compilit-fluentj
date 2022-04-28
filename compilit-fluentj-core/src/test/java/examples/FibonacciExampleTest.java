package examples;

import org.junit.jupiter.api.Test;

import static com.compilit.fluentj.api.operations.ArithmeticOperations.addingThePreviousValueToIt;
import static com.compilit.fluentj.api.operations.ConnectingOperations.and;
import static com.compilit.fluentj.api.operations.LoggerOperations.printIt;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.untilGoingAbove;

class FibonacciExampleTest {

  @Test
  void fluentJFibonacci() {
    startingWith(1,
            keep(addingThePreviousValueToIt(), untilGoingAbove(1000000)),
            and(printIt()));
  }

}
