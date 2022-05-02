package com.compilit.fluentj.api.operations;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public final class DefaultReturningOperations {

  private DefaultReturningOperations() {
  }

  public static <R> Supplier<R> otherwiseReturn(R defaultValue) {
    return () -> defaultValue;
  }

//  public static <T> BiFunction<T, Predicate<T>, T> otherwiseReturn(T defaultValue) {
//    return (value, predicate) -> predicate.test(value) ? value : defaultValue;
//  }

  public static Supplier<Boolean> otherwiseItIsTrue() {
    return () -> true;
  }

  public static Supplier<Boolean> otherwiseItIsFalse() {
    return () -> false;
  }

  public static ConnectingRunnable otherwise(ConnectingRunnable defaultRunnable) {
    return defaultRunnable;
  }

  public static <T> ConnectingConsumer<T> otherwise(ConnectingConsumer<T> defaultConsumer) {
    return defaultConsumer;
  }

  public static <T, R> ConnectingFunction<T, R> otherwise(ConnectingFunction<T, R> defaultFunction) {
    return defaultFunction;
  }
}
