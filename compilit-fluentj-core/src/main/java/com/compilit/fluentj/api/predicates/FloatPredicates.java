package com.compilit.fluentj.api.predicates;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.arithmetic.Modulo.modulatingItBy;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.tryStartingWith;
import static com.compilit.fluentj.api.predicates.Predicates.unless;
import static com.compilit.fluentj.api.predicates.Predicates.untilIt;

public final class FloatPredicates {
  private FloatPredicates() {
  }

  public static Predicate<Float> isEqualTo(final float input) {
    return it -> it == input;
  }

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

  public static Predicate<Float> itIsAPrimeNumber() {
    return thePossiblePrime -> tryStartingWith(2f,
            keep(adding(1f), untilIt(isMoreThenOrEqualTo((float) Math.sqrt(thePossiblePrime)))),
            unless(thePossiblePrime, isDivisibleByTheCurrentNumber()));
  }

  public static BiPredicate<Float, Float> isNotDivisibleByTheCurrentNumber() {
    return isDivisibleByTheCurrentNumber().negate();
  }

  public static BiPredicate<Float, Float> isDivisibleByTheCurrentNumber() {
    return (thePossiblePrime, theCurrentNumber) -> thePossiblePrime % theCurrentNumber == 0;
  }

}
