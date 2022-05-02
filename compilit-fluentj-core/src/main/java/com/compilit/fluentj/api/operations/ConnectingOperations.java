package com.compilit.fluentj.api.operations;

import com.compilit.fluentj.api.expressions.Expression;

import java.util.function.Consumer;
import java.util.function.Function;

public final class ConnectingOperations {
  private ConnectingOperations() {
  }

  public static <T, R> Expression<T, R> and(Expression<T, R> expression) {
    return expression;
  }

  public static ConnectingRunnable and(ConnectingRunnable runnable) {
    return runnable;
  }

  public static <T> ConnectingConsumer<T> and(ConnectingConsumer<T> consumer) {
    return consumer;
  }

  public static <T, R> ConnectingFunction<T, R> and(ConnectingFunction<T, R> function) {
    return function;
  }

}
