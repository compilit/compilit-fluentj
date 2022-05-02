package com.compilit.fluentj.api.predicates;

import com.compilit.fluentj.api.operations.ConnectingConsumer;
import com.compilit.fluentj.api.operations.ConnectingRunnable;

import java.util.Collection;
import java.util.Objects;
import java.util.function.BiPredicate;
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

  public static <T> Predicate<T> or(final T possibleEqual) {
    return it -> Objects.equals(it, possibleEqual);
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

  public static <T> Predicate<T> asLongAsIt(final Predicate<T> predicate) {
    return predicate;
  }

  public static <T> Predicate<T> untilIt(final Predicate<T> predicate) {
    return predicate.negate();
  }

  public static <T> ConnectingConsumer<T> andInCaseThat(final Predicate<T> predicate, ConnectingRunnable runnable) {
    return it -> {
      if (predicate.test(it))
        runnable.run();
    };
  }

  public static <T> ConnectingConsumer<T> andInCaseThat(final Predicate<T> predicate, ConnectingConsumer<T> consumer) {
    return it -> {
      if (predicate.test(it))
        consumer.accept(it);
    };
  }

  public static <T> Predicate<T> andInCaseThat(final Predicate<T> predicate, Supplier<Boolean> supplier, Supplier<Boolean> defaultSupplier) {
    return it -> {
      if (predicate.test(it))
        return supplier.get();
      return defaultSupplier.get();
    };
  }

  @SafeVarargs
  public static <T> Predicate<T> isAnyOf(T value, T... values) {
    Predicate<T> predicate = x -> Objects.equals(x, value);
    if (values != null && values.length > 0) {
      for (var v : values) {
        predicate = predicate.or(x -> Objects.equals(x, v));
      }
    }
    return predicate;
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

  public static <T> Predicate<T> it(Predicate<T> predicate) {
    return predicate;
  }

  public static <T> Predicate<T> isAnythingElse() {
    return it -> true;
  }

  public static <T> Predicate<T> unless(Predicate<T> predicate) {
    return predicate;
  }

  public static <T> Predicate<T> unless(T input, BiPredicate<T, T> predicate) {
    return it -> predicate.test(input, it);
  }

}
