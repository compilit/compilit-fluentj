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

public final class FloatPredicates {
  private FloatPredicates() {}

  public static Predicate<Float> isLessThen(final float input) {
    return it -> it < input;
  }

  public static Predicate<Float> isMoreThen(final float input) {
    return it -> it > input;
  }

  public static Predicate<Float> isMoreThenOrEqualTo(final float input) {
    return it -> it >= input;
  }

  public static Predicate<Float> isLessThenOrEqualTo(final float input) {
    return it -> it <= input;
  }

  public static Predicate<Float> itIsDivisibleByTwo() {
    return it -> modulatingItBy(2f).apply(it) == 0;
  }

  public static Predicate<Float> itIsNotDivisibleByTwo() {
    return itIsDivisibleByTwo().negate();
  }

  public static Predicate<Float> untilReachingOrGoingAbove(final float exclusiveBoundary) {
    return it -> it < exclusiveBoundary;
  }

  public static Predicate<Float> untilReachingOrFallingBelow(final float exclusiveBoundary) {
    return it -> it > exclusiveBoundary;
  }

  public static Predicate<Float> untilGoingAbove(final float inclusiveBoundary) {
    return it -> it <= inclusiveBoundary;
  }

  public static Predicate<Float> untilFallingBelow(final float inclusiveBoundary) {
    return it -> it >= inclusiveBoundary;
  }

  public static Predicate<Float> itIsAPrimeNumber() {
    return itIsEither(1f,
            or(itIsNotDivisibleByAnyOtherNumber()));
  }

  public static BiPredicate<Float, Float> isNotDivisibleByTheCurrentNumber() {
    return isDivisibleByTheCurrentNumber().negate();
  }

  public static BiPredicate<Float, Float> isDivisibleByTheCurrentNumber() {
    return (thePossiblePrime, theCurrentNumber) -> thePossiblePrime % theCurrentNumber == 0;
  }

  private static Predicate<Float> itIsNotDivisibleByAnyOtherNumber() {
    return thePossiblePrime -> tryStartingWith(2f,
            LoopOperations.untilReachingOrGoingAbove(thePossiblePrime / 2f, keep(Addition.adding(1f))),
            unless(thePossiblePrime, isDivisibleByTheCurrentNumber()));
  }



}
