package com.compilit.fluentj.api.loops;

import com.compilit.fluentj.api.operations.ConnectingConsumer;
import com.compilit.fluentj.api.operations.ConnectingUnaryOperator;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public final class LoopOperations {

  private LoopOperations() {
  }

  @SafeVarargs
  public static <T> Loop<T> asLongAsIt(final Predicate<T> predicate, ConnectingUnaryOperator<T> function, ConnectingConsumer<T>... consumers) {
    return new WhileLoop<>(function, predicate, List.of(consumers));
  }

  @SafeVarargs
  public static <T> Loop<T> untilIt(final Predicate<T> predicate, ConnectingUnaryOperator<T> function, ConnectingConsumer<T>... consumers) {
    return new DoWhileLoop<>(function, predicate.negate(), List.of(consumers));
  }

  @SafeVarargs
  public static <T> Loop<T> keep(ConnectingUnaryOperator<T> function, Predicate<T> predicate, ConnectingConsumer<T>... consumers) {
    return new WhileLoop<>(function, predicate, List.of(consumers));
  }

  @SafeVarargs
  public static <T> Loop<T> keep(BiFunction<T, T, T> biFunction, ConnectingConsumer<T>... consumers) {
    return new BiFunctionWhileLoop<>(biFunction, List.of(consumers));
  }

  @SafeVarargs
  public static <T> Loop<T> keep(BiFunction<T, T, T> biFunction, Predicate<T> predicate, ConnectingConsumer<T>... consumers) {
    return new BiFunctionWhileLoop<>(biFunction, predicate.negate(), List.of(consumers));
  }

  public static <T> ConnectingUnaryOperator<T> keep(ConnectingUnaryOperator<T> function) {
    return function;
  }

}
