package com.compilit.fluentj.api.loops;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public final class LoopOperations {

  private LoopOperations() {
  }

  @SafeVarargs
  public static <T> Loop<T> asLongAs(final Predicate<T> predicate, UnaryOperator<T> function, Consumer<T>... consumers) {
    return new WhileLoop<>(function, predicate, List.of(consumers));
  }

  @SafeVarargs
  public static <T> Loop<T> until(final Predicate<T> predicate, UnaryOperator<T> function, Consumer<T>... consumers) {
    return new DoWhileLoop<>(function, predicate.negate(), List.of(consumers));
  }

  @SafeVarargs
  public static <T> Loop<T> keep(UnaryOperator<T> function, Predicate<T> predicate, Consumer<T>... consumers) {
    return new WhileLoop<>(function, predicate, List.of(consumers));
  }

  @SafeVarargs
  public static <T> Loop<T> keep(BiFunction<T, T, T> biFunction, Consumer<T>... consumers) {
    return new BiFunctionWhileLoop<>(biFunction, List.of(consumers));
  }

  @SafeVarargs
  public static <T> Loop<T> keep(BiFunction<T, T, T> biFunction, Predicate<T> predicate, Consumer<T>... consumers) {
    return new BiFunctionWhileLoop<>(biFunction, predicate.negate(), List.of(consumers));
  }

  public static <T> UnaryOperator<T> keep(UnaryOperator<T> function) {
    return function;
  }

}
