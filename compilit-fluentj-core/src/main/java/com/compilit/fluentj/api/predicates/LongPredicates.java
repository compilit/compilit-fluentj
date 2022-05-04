package com.compilit.fluentj.api.predicates;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.tryStartingWith;
import static com.compilit.fluentj.api.predicates.Predicates.unless;
import static com.compilit.fluentj.api.predicates.Predicates.until;

public final class LongPredicates {

  private LongPredicates() {
  }

  public static Predicate<Long> itIsEqualTo(final long input) {
    return it -> it == input;
  }

  public static Predicate<Long> itIsGreaterThen(final long input) {
    return it -> it > input;
  }

  public static Predicate<Long> itIsLessThen(final long input) {
    return it -> it < input;
  }

  public static Predicate<Long> itIsGreaterThenOrEqualTo(final long input) {
    return it -> it >= input;
  }

  public static Predicate<Long> itIsLessThenOrEqualTo(final long input) {
    return it -> it <= input;
  }

  public static Predicate<Long> itIsAPrimeNumber() {
    return thePossiblePrime -> tryStartingWith(2L,
            keep(adding(1L), until(itIsGreaterThen((long) Math.sqrt(thePossiblePrime)))),
            unless(thePossiblePrime, itIsDivisibleByTheCurrentNumber()));
  }

  public static BiPredicate<Long, Long> itIsNotDivisibleByTheCurrentNumber() {
    return itIsDivisibleByTheCurrentNumber().negate();
  }

  public static BiPredicate<Long, Long> itIsDivisibleByTheCurrentNumber() {
    return (input, theCurrentNumber) -> input % theCurrentNumber == 0;
  }

}
