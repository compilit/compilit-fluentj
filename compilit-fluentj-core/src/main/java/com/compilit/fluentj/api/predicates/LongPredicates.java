package com.compilit.fluentj.api.predicates;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.tryStartingWith;
import static com.compilit.fluentj.api.predicates.Predicates.unless;
import static com.compilit.fluentj.api.predicates.Predicates.untilIt;

public final class LongPredicates {
  public static Predicate<Long> isEqualTo(final long input) {
    return it -> it == input;
  }

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

  public static Predicate<Long> itIsAPrimeNumber() {
    return thePossiblePrime -> tryStartingWith(2L,
            keep(adding(1L), untilIt(isMoreThenOrEqualTo((long) Math.sqrt(thePossiblePrime)))),
            unless(thePossiblePrime, isDivisibleByTheCurrentNumber()));
  }

  public static BiPredicate<Long, Long> isNotDivisibleByTheCurrentNumber() {
    return isDivisibleByTheCurrentNumber().negate();
  }

  public static BiPredicate<Long, Long> isDivisibleByTheCurrentNumber() {
    return (thePossiblePrime, theCurrentNumber) -> thePossiblePrime % theCurrentNumber == 0;
  }

}
