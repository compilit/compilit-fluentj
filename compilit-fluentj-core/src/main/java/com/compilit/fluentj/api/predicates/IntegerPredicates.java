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
import static com.compilit.fluentj.api.arithmetic.Modulo.modulatingItBy;

public final class IntegerPredicates {
  private IntegerPredicates() {}

  public static Predicate<Integer> isLessThen(final int input) {
    return it -> it < input;
  }

  public static Predicate<Integer> isMoreThen(final int input) {
    return it -> it > input;
  }

  public static Predicate<Integer> isMoreThenOrEqualTo(final int input) {
    return it -> it >= input;
  }

  public static Predicate<Integer> isLessThenOrEqualTo(final int input) {
    return it -> it <= input;
  }

  public static Predicate<Integer> itIsDivisibleByTwo() {
    return it -> modulatingItBy(2).apply(it) == 0;
  }

  public static Predicate<Integer> itIsNotDivisibleByTwo() {
    return itIsDivisibleByTwo().negate();
  }

  public static Predicate<Integer> untilReachingOrGoingAbove(final int exclusiveBoundary) {
    return it -> it < exclusiveBoundary;
  }

  public static Predicate<Integer> untilReachingOrFallingBelow(final int exclusiveBoundary) {
    return it -> it > exclusiveBoundary;
  }

  public static Predicate<Integer> untilGoingAbove(final int inclusiveBoundary) {
    return it -> it <= inclusiveBoundary;
  }

  public static Predicate<Integer> untilFallingBelow(final int inclusiveBoundary) {
    return it -> it >= inclusiveBoundary;
  }

  public static Predicate<Integer> itIsAPrimeNumber() {
    return itIsEither(1,
            or(itIsNotDivisibleByAnyOtherNumber()));
  }

  public static BiPredicate<Integer, Integer> isNotDivisibleByTheCurrentNumber() {
    return isDivisibleByTheCurrentNumber().negate();
  }

  public static BiPredicate<Integer, Integer> isDivisibleByTheCurrentNumber() {
    return (thePossiblePrime, theCurrentNumber) -> thePossiblePrime % theCurrentNumber == 0;
  }

  private static Predicate<Integer> itIsNotDivisibleByAnyOtherNumber() {
    return thePossiblePrime -> tryStartingWith(2,
            LoopOperations.untilReachingOrGoingAbove(thePossiblePrime / 2, keep(Addition.adding(1))),
            unless(thePossiblePrime, isDivisibleByTheCurrentNumber()));
  }

}
