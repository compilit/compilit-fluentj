package com.compilit.fluentj.api.operations;

import java.util.function.Supplier;

public final class DefaultReturningOperations {

  private DefaultReturningOperations() {
  }

  public static <T> Supplier<T> otherwiseReturn(T defaultValue) {
    return () -> defaultValue;
  }

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
