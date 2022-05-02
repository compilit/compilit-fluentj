package com.compilit.fluentj.api.predicates;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.arithmetic.Modulo.modulatingItBy;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.tryStartingWith;
import static com.compilit.fluentj.api.predicates.Predicates.unless;
import static com.compilit.fluentj.api.predicates.Predicates.untilIt;

public final class IntegerPredicates {
  private IntegerPredicates() {
  }

  public static Predicate<Integer> isEqualTo(final int input) {
    return it -> it == input;
  }

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

  public static Predicate<Integer> itIsAPrimeNumber() {
    return thePossiblePrime -> tryStartingWith(2,
            keep(adding(1), untilIt(isMoreThenOrEqualTo((int) Math.sqrt(thePossiblePrime)))),
            unless(thePossiblePrime, isDivisibleByTheCurrentNumber()));
  }

  public static Predicate<Integer> itIsDivisibleByTwo() {
    return it -> modulatingItBy(2).apply(it) == 0;
  }

  public static Predicate<Integer> itIsNotDivisibleByTwo() {
    return itIsDivisibleByTwo().negate();
  }

  public static BiPredicate<Integer, Integer> isDivisibleByTheCurrentNumber() {
    return (thePossiblePrime, theCurrentNumber) -> thePossiblePrime % theCurrentNumber == 0;
  }

  public static BiPredicate<Integer, Integer> isNotDivisibleByTheCurrentNumber() {
    return isDivisibleByTheCurrentNumber().negate();
  }

}
