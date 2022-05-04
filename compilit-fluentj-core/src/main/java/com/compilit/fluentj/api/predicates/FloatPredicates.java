package com.compilit.fluentj.api.predicates;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.arithmetic.Modulo.modulatingItBy;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.tryStartingWith;
import static com.compilit.fluentj.api.predicates.Predicates.unless;
import static com.compilit.fluentj.api.predicates.Predicates.until;

public final class FloatPredicates {
  private FloatPredicates() {
  }

  public static Predicate<Float> itIsEqualTo(final float input) {
    return it -> it == input;
  }

  public static Predicate<Float> itIsLessThen(final float input) {
    return it -> it < input;
  }

  public static Predicate<Float> itIsGreaterThen(final float input) {
    return it -> it > input;
  }

  public static Predicate<Float> itIsGreaterThanOrEqualTo(final float input) {
    return it -> it >= input;
  }

  public static Predicate<Float> itIsLessThenOrEqualTo(final float input) {
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
            keep(adding(1f), until(itIsGreaterThen((float) Math.sqrt(thePossiblePrime)))),
            unless(thePossiblePrime, itIsDivisibleByTheCurrentNumber()));
  }

  public static BiPredicate<Float, Float> itIsNotDivisibleByTheCurrentNumber() {
    return itIsDivisibleByTheCurrentNumber().negate();
  }

  public static BiPredicate<Float, Float> itIsDivisibleByTheCurrentNumber() {
    return (input, theCurrentNumber) -> input % theCurrentNumber == 0;
  }

}
