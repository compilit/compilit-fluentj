package com.compilit.fluentj.api.predicates;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.arithmetic.Modulo.modulatingItBy;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.tryStartingWith;
import static com.compilit.fluentj.api.predicates.Predicates.unless;
import static com.compilit.fluentj.api.predicates.Predicates.until;

public final class IntegerPredicates {
  private IntegerPredicates() {
  }

  public static Predicate<Integer> itIsEqualTo(final int input) {
    return it -> it == input;
  }

  public static Predicate<Integer> itIsLessThen(final int input) {
    return it -> it < input;
  }

  public static Predicate<Integer> itIsGreaterThen(final int input) {
    return it -> it > input;
  }

  public static Predicate<Integer> itIsGreaterThanOrEqualTo(final int input) {
    return it -> it >= input;
  }

  public static Predicate<Integer> itIsEqualToOrLessThen(final int input) {
    return it -> it <= input;
  }

  public static Predicate<Integer> itIsAPrimeNumber() {
    return thePossiblePrime -> tryStartingWith(2,
            keep(adding(1), until(itIsGreaterThen((int) Math.sqrt(thePossiblePrime)))),
            unless(thePossiblePrime, itIsDivisibleByTheCurrentNumber()));
  }

  public static Predicate<Integer> itIsDivisibleByTwo() {
    return it -> modulatingItBy(2).apply(it) == 0;
  }

  public static Predicate<Integer> itIsNotDivisibleByTwo() {
    return itIsDivisibleByTwo().negate();
  }

  public static BiPredicate<Integer, Integer> itIsDivisibleByTheCurrentNumber() {
    return (input, theCurrentNumber) -> input % theCurrentNumber == 0;
  }

  public static BiPredicate<Integer, Integer> itIsNotDivisibleByTheCurrentNumber() {
    return itIsDivisibleByTheCurrentNumber().negate();
  }

}
