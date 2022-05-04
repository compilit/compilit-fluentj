package com.compilit.fluentj.api.predicates;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.arithmetic.Modulo.modulatingItBy;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.tryStartingWith;
import static com.compilit.fluentj.api.predicates.Predicates.unless;
import static com.compilit.fluentj.api.predicates.Predicates.until;

public final class DoublePredicates {
  private DoublePredicates() {
  }

  public static Predicate<Double> itIsEqualTo(final double input) {
    return it -> it == input;
  }

  public static Predicate<Double> itIsLessThen(final double input) {
    return it -> it < input;
  }

  public static Predicate<Double> itIsGreaterThen(final double input) {
    return it -> it > input;
  }

  public static Predicate<Double> itIsGreaterThenOrEqualTo(final double input) {
    return it -> it >= input;
  }

  public static Predicate<Double> itIsLessThenOrEqualTo(final double input) {
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
            keep(adding(1d), until(itIsGreaterThen(Math.sqrt(thePossiblePrime)))),
            unless(thePossiblePrime, itIsDivisibleByTheCurrentNumber()));
  }

  public static BiPredicate<Double, Double> itIsNotDivisibleByTheCurrentNumber() {
    return itIsDivisibleByTheCurrentNumber().negate();
  }

  public static BiPredicate<Double, Double> itIsDivisibleByTheCurrentNumber() {
    return (input, theCurrentNumber) -> input % theCurrentNumber == 0;
  }

}
