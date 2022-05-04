package com.compilit.fluentj.api.predicates;

import java.util.Collection;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class Predicates {

  private Predicates() {
  }

  public static <T> Predicate<T> is(final T input) {
    return it -> Objects.equals(it, input);
  }

  public static <T> Predicate<T> isNot(final T input) {
    return is(input).negate();
  }

  public static <T> Predicate<T> forever() {
    return it -> true;
  }

  @SafeVarargs
  public static <T> Predicate<T> itIsEither(final T possibleEqual, final Predicate<T> initialPredicate, final Predicate<T>... predicates) {
    Predicate<T> original = itIs(possibleEqual).or(initialPredicate);
    if (predicates != null && predicates.length > 0) {
      for (var predicate : predicates) {
        original = original.or(predicate);
      }
    }
    return original;
  }

  @SafeVarargs
  public static <T> Predicate<T> itIsNeither(final T possibleEqual, final Predicate<T> initialPredicate, final Predicate<T>... predicates) {
    Predicate<T> original = itIsNot(possibleEqual).and(initialPredicate);
    if (predicates != null && predicates.length > 0) {
      for (var predicate : predicates) {
        original = original.and(predicate);
      }
    }
    return original;
  }

  public static <T> Predicate<T> or(final Predicate<T> predicate) {
    return predicate;
  }

  public static <T> Predicate<T> and(final Predicate<T> predicate) {
    return predicate;
  }

  public static <T> Predicate<T> itIs(final T possibleEqual) {
    return it -> Objects.equals(it, possibleEqual);
  }

  public static <T> Predicate<T> itIsNull() {
    return Objects::isNull;
  }


  public static <T> Predicate<T> itIsNot(final T possibleEqual) {
    return itIs(possibleEqual).negate();
  }

  public static <T> Predicate<T> itIsNotNull() {
    return Objects::nonNull;
  }

  public static <T> Predicate<T> isNull() {
    return Objects::isNull;
  }

  public static <T> Predicate<T> isNotNull() {
    return Objects::nonNull;
  }

  public static <T> Predicate<Collection<T>> itContains(T entry) {
    return it -> it.contains(entry);
  }

  public static <T> Predicate<Collection<T>> itDoesNotContain(T entry) {
    return itContains(entry).negate();
  }

  public static <T> Predicate<T> asLongAs(final Predicate<T> predicate) {
    return predicate;
  }

  public static <T> Predicate<T> until(final Predicate<T> predicate) {
    return predicate.negate();
  }

  public static <T> Consumer<T> andInCaseThat(final Predicate<T> predicate, Runnable runnable) {
    return it -> {
      if (predicate.test(it))
        runnable.run();
    };
  }

  public static <T> Consumer<T> andInCaseThat(final Predicate<T> predicate, Consumer<T> consumer) {
    return it -> {
      if (predicate.test(it))
        consumer.accept(it);
    };
  }

  public static <T, R> Function<T, T> andInCaseThat(final Predicate<T> predicate, Supplier<T> supplier, Supplier<T> defaultSupplier) {
    return it -> {
      if (predicate.test(it))
        return supplier.get();
      return defaultSupplier.get();
    };
  }

  public static <T> Predicate<T> itIsAnInteger() {
    return itIsAnInstanceOf(Integer.class);
  }

  public static <T> Predicate<T> itIsAFloat() {
    return itIsAnInstanceOf(Float.class);
  }

  public static <T> Predicate<T> itIsADouble() {
    return itIsAnInstanceOf(Double.class);
  }

  public static <T> Predicate<T> itIsALong() {
    return itIsAnInstanceOf(Long.class);
  }

  public static <T> Predicate<T> itIsAString() {
    return itIsAnInstanceOf(String.class);
  }

  public static <T> Predicate<T> itIsAnInstanceOf(Class<?> clazz) {
    return clazz::isInstance;
  }

  public static <T> Predicate<T> itIsAnythingElse() {
    return it -> false;
  }

  public static <T> Predicate<T> unless(Predicate<T> predicate) {
    return predicate;
  }

  public static <T> Predicate<T> unless(T input, BiPredicate<T, T> predicate) {
    return it -> predicate.test(input, it);
  }

}
