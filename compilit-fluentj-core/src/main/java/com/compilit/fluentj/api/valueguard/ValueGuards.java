package com.compilit.fluentj.api.valueguard;

import java.util.function.Function;
import java.util.function.Supplier;

public class ValueGuards {

  private ValueGuards() {
  }

  public static <T> T orNull(Supplier<T> supplier) {
    return ignoreException(supplier, null);
  }

  public static <T> T orDefault(Supplier<T> supplier, T defaultValue) {
    return ignoreException(supplier, defaultValue);
  }

  public static Integer asIntegerOrNull(Supplier<String> supplier) {
    return ignoreException(() -> Integer.valueOf(supplier.get()), null);
  }

  public static Integer asIntegerOrOtherwise(Supplier<String> supplier, Integer defaultValue) {
    return ignoreException(() -> Integer.valueOf(supplier.get()), defaultValue);
  }

  public static <T> T castOrNull(T value, Class<?> clazz) {
    return ignoreException(() -> (T) clazz.cast(value), null);
  }

  public static <T, R> R cast(T value, Function<T, R> function) {
      return orNull(() -> function.apply(value));
  }

  public static <T, R> R cast(T value, Function<T, R> function, Supplier<R> defaultSupplier) {
    return orDefault(() -> function.apply(value), defaultSupplier.get());
  }

  private static <T> T ignoreException(Supplier<T> supplier, T defaultValue) {
    try {
      return supplier.get();
    } catch (Exception ignored) {
      return defaultValue;
    }
  }

}
