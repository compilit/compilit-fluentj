package com.compilit.fluentj.api.predicates;

import com.compilit.fluentj.api.loops.LoopOperations;
import com.compilit.fluentj.api.arithmetic.Addition;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.tryStartingWith;
import static com.compilit.fluentj.api.predicates.Predicates.itIsEither;
import static com.compilit.fluentj.api.predicates.Predicates.or;
import static com.compilit.fluentj.api.predicates.Predicates.unless;

public final class LongPredicates {

  public static Predicate<Long> isMoreThen(final long input) {
    return it -> it > input;
  }

  public static Predicate<Long> isLessThen(final long input) {
    return it -> it < input;
  }
  public static Predicate<Long> isMoreThenOrEqualTo(final long input) {
    return it -> it >= input;
  }

  public static Predicate<Long> isLessThenOrEqualTo(final long input) {
    return it -> it <= input;
  }

  public static Predicate<Long> untilReachingOrGoingAbove(final long exclusiveBoundary) {
    return it -> it < exclusiveBoundary;
  }

  public static Predicate<Long> untilReachingOrFallingBelow(final long exclusiveBoundary) {
    return it -> it > exclusiveBoundary;
  }

  public static Predicate<Long> untilGoingAbove(final long inclusiveBoundary) {
    return it -> it <= inclusiveBoundary;
  }

  public static Predicate<Long> untilFallingBelow(final long inclusiveBoundary) {
    return it -> it >= inclusiveBoundary;
  }

  public static Predicate<Long> itIsAPrimeNumber() {
    return itIsEither(1L,
            or(itIsNotDivisibleByAnyOtherNumber()));
  }

  public static BiPredicate<Long, Long> isNotDivisibleByTheCurrentNumber() {
    return isDivisibleByTheCurrentNumber().negate();
  }

  public static BiPredicate<Long, Long> isDivisibleByTheCurrentNumber() {
    return (thePossiblePrime, theCurrentNumber) -> thePossiblePrime % theCurrentNumber == 0;
  }

  private static Predicate<Long> itIsNotDivisibleByAnyOtherNumber() {
    return thePossiblePrime -> tryStartingWith(2L,
            LoopOperations.untilReachingOrGoingAbove(thePossiblePrime / 2L, keep(Addition.adding(1L))),
            unless(thePossiblePrime, isDivisibleByTheCurrentNumber()));
  }

}
