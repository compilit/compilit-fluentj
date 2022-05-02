package com.compilit.fluentj.api.operations;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public final class ExceptionOperations {
  private ExceptionOperations() {
  }

  public static ConnectingConsumer<Throwable> inCaseOfAnException(final ConnectingConsumer<Throwable> throwableConsumer) {
    return throwableConsumer;
  }

  public static <T> ConnectingFunction<Supplier<T>, T> inCaseOfAnExceptionReturn(T defaultValue) {
    return it -> inCaseOfAnExceptionReturnDefault(it, defaultValue);
  }

  static <T> T inCaseOfAnExceptionReturnDefault(Supplier<T> supplier, T defaultValue) {
    try {
      return supplier.get();
    } catch (Exception ignored) {
      return defaultValue;
    }
  }

}
