package com.compilit.fluentj.api.predicates;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.arithmetic.Modulo.modulatingItBy;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.tryStartingWith;
import static com.compilit.fluentj.api.predicates.Predicates.unless;
import static com.compilit.fluentj.api.predicates.Predicates.untilIt;

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

  public static Predicate<Double> itIsAPrimeNumber() {
    return thePossiblePrime -> tryStartingWith(2d,
            keep(adding(1d), untilIt(isMoreThenOrEqualTo(Math.sqrt(thePossiblePrime)))),
            unless(thePossiblePrime, isDivisibleByTheCurrentNumber()));
  }

  public static BiPredicate<Double, Double> isNotDivisibleByTheCurrentNumber() {
    return isDivisibleByTheCurrentNumber().negate();
  }

  public static BiPredicate<Double, Double> isDivisibleByTheCurrentNumber() {
    return (thePossiblePrime, theCurrentNumber) -> thePossiblePrime % theCurrentNumber == 0;
  }

}
