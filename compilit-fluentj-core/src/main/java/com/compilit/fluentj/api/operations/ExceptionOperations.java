package com.compilit.fluentj.api.operations;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.compilit.fluentj.api.operations.ReturningOperations.thenReturn;

public final class ExceptionOperations {
  private ExceptionOperations() {
  }

  public static Consumer<Throwable> inCaseOfAnException(final Consumer<Throwable> throwableConsumer) {
    return throwableConsumer;
  }

  public static <T> Function<Supplier<T>, T> inCaseOfAnExceptionReturn(T defaultValue) {
    return it -> inCaseOfAnExceptionReturnDefault(it, thenReturn(defaultValue));
  }

  static <T> T inCaseOfAnExceptionReturnDefault(Supplier<T> supplier, Supplier<T> defaultValue) {
    try {
      return supplier.get();
    } catch (Exception ignored) {
      return defaultValue.get();
    }
  }

}
