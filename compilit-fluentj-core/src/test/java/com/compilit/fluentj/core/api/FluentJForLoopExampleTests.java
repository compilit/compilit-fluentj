package com.compilit.fluentj.core.api;

import com.compilit.results.Result;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import testutil.AbstractTestWithContext;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.arithmetic.Multiplication.multiplyingItBy;
import static com.compilit.fluentj.api.arithmetic.Subtraction.subtractingItWith;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.untilReachingOrFallingBelow;
import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.untilFallingBelow;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.untilGoingAbove;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.untilReachingOrGoingAbove;

import static com.compilit.fluentj.api.operations.ReturningOperations.thenReturnTheResult;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FluentJForLoopExampleTests extends AbstractTestWithContext {

  private static final Supplier<Result<?>> testCase1 =
          () -> startingWith(1,
                  keep(multiplyingItBy(10), untilReachingOrGoingAbove(10)),
                  thenReturnTheResult());
  private static final Supplier<Result<?>> testCase2 =
          () -> startingWith(1,
                  keep(multiplyingItBy(10), untilGoingAbove(10)),
                  thenReturnTheResult());
  private static final Supplier<Result<?>> testCase3 =
          () -> startingWith(10,
                  keep(multiplyingItBy(10), untilGoingAbove(1000)),
                  thenReturnTheResult());
  private static final Supplier<Result<?>> testCase4 =
          () -> startingWith(0,
                  keep(adding(1), untilReachingOrGoingAbove(10)),
                  thenReturnTheResult());
  private static final Supplier<Result<?>> testCase5 =
          () -> startingWith(1000,
                  keep(subtractingItWith(1), untilReachingOrFallingBelow(-1000)),
                  thenReturnTheResult());
  private static final Supplier<Result<?>> testCase6 =
          () -> startingWith(1000,
                  keep(subtractingItWith(1), untilFallingBelow(-1000)),
                  thenReturnTheResult());
  private static final Supplier<Result<?>> testCase7 =
          () -> startingWith(1000,
                  keep(multiplyingItBy(-2), untilReachingOrFallingBelow(0)),
                  thenReturnTheResult());
  private static final Supplier<Result<?>> testCase8 =
          () -> startingWith(1000,
                  keep(multiplyingItBy(-2), untilFallingBelow(0)),
                  thenReturnTheResult());
  private static final Supplier<Result<?>> testCase9 =
          () -> startingWith(0,
                  keep(adding(1), untilGoingAbove(10)),
                  thenReturnTheResult());

  @ParameterizedTest
  @MethodSource("forLoopTestCases")
  void forLoop_testCase_shouldLoopUntilTheBoundary(Supplier<Result<?>> testCase, Number expected) {
    var result = testCase.get();
    assertThat(result.getContents()).isEqualTo(expected);
  }

  private static Stream<Arguments> forLoopTestCases() {
    return Stream.of(
            arguments(testCase1, 10),
            arguments(testCase2, 100),
            arguments(testCase3, 10000),
            arguments(testCase4, 10),
            arguments(testCase5, -1000),
            arguments(testCase6, -1001),
            arguments(testCase7, -2000),
            arguments(testCase8, -2000),
            arguments(testCase9, 11)
    );
  }

}