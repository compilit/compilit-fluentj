package com.compilit.fluentj.core.api.arithmetic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.arithmetic.Addition.incrementingIt;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.operations.ConnectingOperations.and;
import static com.compilit.fluentj.api.operations.LoggerOperations.printIt;
import static com.compilit.fluentj.api.operations.ReturningOperations.thenReturnTheResult;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.itIsMoreThen;
import static com.compilit.fluentj.api.predicates.Predicates.until;

public class AdditionsTests {

  @Test
  void adding_shouldAddUntilGoingAboveBoundary() {
    var actual = startingWith(1,
            keep(adding(1), until(itIsMoreThen(100)), and(printIt())),
            thenReturnTheResult());
    Assertions.assertThat(actual.getContents()).isEqualTo(101);
  }

  @Test
  void incrementingIt_shouldIncrementUntilGoingAboveBoundary() {
    var actual = startingWith(1,
            keep(incrementingIt(), until(itIsMoreThen(100)), and(printIt())),
            thenReturnTheResult());
    Assertions.assertThat(actual.getContents()).isEqualTo(128);
  }

}
