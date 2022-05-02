package com.compilit.fluentj.api.operations;

import java.util.function.Supplier;

import static com.compilit.fluentj.api.operations.ExceptionOperations.inCaseOfAnExceptionReturnDefault;

public final class CastingOperations<T> {

  private CastingOperations() {
  }

  public static <T, R> CastingFunction<T, R> to(Class<R> clazz) {
    return clazz::cast;
  }

  public static <T, R> R cast(T value, CastingFunction<T, R> function, Supplier<R> defaultSupplier, ConnectingConsumer<Throwable> throwableConsumer) {
    try {
      return function.apply(value);
    } catch (Exception exception) {
      throwableConsumer.accept(exception);
    }
    return defaultSupplier.get();
  }

  public static <T, R> R cast(T value, CastingFunction<T, R> function, Supplier<R> defaultSupplier) {
    return inCaseOfAnExceptionReturnDefault(() -> function.apply(value), defaultSupplier);
  }

}
