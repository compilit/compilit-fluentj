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

  public static Supplier<Boolean> otherwiseItIsTrue() {
    return () -> true;
  }

  public static Supplier<Boolean> otherwiseItIsFalse() {
    return () -> false;
  }

  public static Runnable otherwise(Runnable defaultRunnable) {
    return defaultRunnable;
  }

  public static <T> Consumer<T> otherwise(Consumer<T> defaultConsumer) {
    return defaultConsumer;
  }

  public static <T, R> Function<T, R> otherwise(Function<T, R> defaultFunction) {
    return defaultFunction;
  }
}
