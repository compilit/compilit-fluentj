package com.compilit.fluentj.api.predicates;

import com.compilit.fluentj.api.arithmetic.Addition;
import com.compilit.fluentj.api.loops.LoopOperations;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static com.compilit.fluentj.api.arithmetic.Modulo.modulatingItBy;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.tryStartingWith;
import static com.compilit.fluentj.api.predicates.Predicates.itIsEither;
import static com.compilit.fluentj.api.predicates.Predicates.or;
import static com.compilit.fluentj.api.predicates.Predicates.unless;

public final class DoublePredicates {
  private DoublePredicates() {
  }
  public static Predicate<Double> isEqualTo(final double input) {
    return it -> it == input;
  }
  public static Predicate<Double> isLessThen(final double input) {
    return it -> it < input;
  }

  public static Predicate<Double> isMoreThen(final double input) {
    return it -> it > input;
  }

  public static Predicate<Double> isMoreThenOrEqualTo(final double input) {
    return it -> it >= input;
  }

  public static Predicate<Double> isLessThenOrEqualTo(final double input) {
    return it -> it <= input;
  }

  public static Predicate<Double> itIsDivisibleByTwo() {
    return it -> modulatingItBy(2d).apply(it) == 0;
  }

  public static Predicate<Double> itIsNotDivisibleByTwo() {
    return itIsDivisibleByTwo().negate();
  }

  public static Predicate<Double> untilReachingOrGoingAbove(final double exclusiveBoundary) {
    return it -> it < exclusiveBoundary;
  }

  public static Predicate<Double> untilReachingOrFallingBelow(final double exclusiveBoundary) {
    return it -> it > exclusiveBoundary;
  }

  public static Predicate<Double> untilGoingAbove(final double inclusiveBoundary) {
    return it -> it <= inclusiveBoundary;
  }

  public static Predicate<Double> untilFallingBelow(final double inclusiveBoundary) {
    return it -> it >= inclusiveBoundary;
  }

  public static Predicate<Double> itIsAPrimeNumber() {
    return itIsEither(1d,
            or(itIsNotDivisibleByAnyOtherNumber()));
  }

  public static BiPredicate<Double, Double> isNotDivisibleByTheCurrentNumber() {
    return isDivisibleByTheCurrentNumber().negate();
  }

  public static BiPredicate<Double, Double> isDivisibleByTheCurrentNumber() {
    return (thePossiblePrime, theCurrentNumber) -> thePossiblePrime % theCurrentNumber == 0;
  }

  private static Predicate<Double> itIsNotDivisibleByAnyOtherNumber() {
    return thePossiblePrime -> tryStartingWith(2d,
            LoopOperations.untilReachingOrGoingAbove(thePossiblePrime / 2, keep(Addition.adding(1d))),
            unless(thePossiblePrime, isDivisibleByTheCurrentNumber()));
  }

}
