package com.compilit.fluentj.api.operations;

import com.compilit.fluentj.api.expressions.Expression;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public final class ConnectingOperations {
  private ConnectingOperations() {
  }

  public static <T, R> Expression<T, R> and(Expression<T, R> expression) {
    return expression;
  }

  public static <T> Consumer<T> and(Runnable runnable) {
    return x -> runnable.run();
  }

  public static <T> Consumer<T> and(Consumer<T> consumer) {
    return consumer;
  }

  public static <T, R> Function<T, R> and(Function<T, R> function) {
    return function;
  }
  public static <R> Supplier<R> and(Supplier<R> supplier) {
    return supplier;
  }

  public static Runnable then(Runnable runnable) {
    return runnable;
  }

  public static <T> Consumer<T> then(Consumer<T> consumer) {
    return consumer;
  }

}
