package com.compilit.fluentj.api.operations;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.compilit.fluentj.api.operations.ExceptionOperations.inCaseOfAnExceptionReturnDefault;

public final class CastingOperations<T> {

  private CastingOperations() {
  }

  public static <T, R> CastingFunction<T, R> to(Class<R> clazz) {
    return clazz::cast;
  }
  public static <T, R> CastingFunction<T, R> toA(Class<R> clazz) {
    return to(clazz);
  }
    public static <T, R> CastingFunction<T, R> toAn(Class<R> clazz) {
      return to(clazz);
  }

  public static <T, R> CastingFunction<T, R> castItTo(Class<R> clazz, Supplier<R> defaultSupplier, Consumer<Throwable> throwableConsumer) {
    return it -> {
      try {
        return clazz.cast(it);
      } catch (Exception exception) {
        throwableConsumer.accept(exception);
      }
      return defaultSupplier.get();
    };
  }

  public static <T, R> CastingFunction<T, R> itToA(Class<R> clazz, Supplier<R> defaultSupplier, Consumer<Throwable> throwableConsumer) {
    return castItTo(clazz, defaultSupplier, throwableConsumer);
  }

  public static <T, R> CastingFunction<T, R> itToAn(Class<R> clazz, Supplier<R> defaultSupplier, Consumer<Throwable> throwableConsumer) {
    return castItTo(clazz, defaultSupplier, throwableConsumer);
  }

  public static <T, R> R cast(T value, CastingFunction<T, R> function, Supplier<R> defaultSupplier, Consumer<Throwable> throwableConsumer) {
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

  public static <T, R> Consumer<T> cast(CastingFunction<T, R> function, Supplier<R> defaultSupplier) {
    return it -> inCaseOfAnExceptionReturnDefault(() -> function.apply(it), defaultSupplier);
  }

}
