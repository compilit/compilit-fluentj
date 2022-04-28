package com.compilit.fluentj.api.operations;

import java.util.function.Consumer;
import java.util.function.Function;

public final class ConnectingOperations {
  private ConnectingOperations() {
  }

  public static Runnable and(Runnable runnable) {
    return runnable;
  }

  public static <T> Consumer<T> and(Consumer<T> consumer) {
    return consumer;
  }

  public static <T, R> Function<T, R> and(Function<T, R> function) {
    return function;
  }

}
