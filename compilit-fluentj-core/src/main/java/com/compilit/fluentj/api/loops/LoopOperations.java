package com.compilit.fluentj.api.loops;

import com.compilit.fluentj.api.operations.ConnectingConsumer;
import com.compilit.fluentj.api.operations.ConnectingUnaryOperator;
import com.compilit.fluentj.api.predicates.DoublePredicates;
import com.compilit.fluentj.api.predicates.FloatPredicates;
import com.compilit.fluentj.api.predicates.IntegerPredicates;
import com.compilit.fluentj.api.predicates.LongPredicates;

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
  public static Loop<Integer> untilReachingOrGoingAbove(final int exclusiveBoundary, ConnectingUnaryOperator<Integer> function, ConnectingConsumer<Integer>... consumers) {
    return new DoWhileLoop<>(function, IntegerPredicates.isMoreThen(exclusiveBoundary).negate(), List.of(consumers));
  }

  @SafeVarargs
  public static Loop<Long> untilReachingOrGoingAbove(final long exclusiveBoundary, ConnectingUnaryOperator<Long> function, ConnectingConsumer<Long>... consumers) {
    return new DoWhileLoop<>(function, LongPredicates.isMoreThen(exclusiveBoundary).negate(), List.of(consumers));
  }

  @SafeVarargs
  public static Loop<Float> untilReachingOrGoingAbove(final float exclusiveBoundary, ConnectingUnaryOperator<Float> function, ConnectingConsumer<Float>... consumers) {
    return new DoWhileLoop<>(function, FloatPredicates.isMoreThen(exclusiveBoundary).negate(), List.of(consumers));
  }

  @SafeVarargs
  public static Loop<Double> untilReachingOrGoingAbove(final double exclusiveBoundary, ConnectingUnaryOperator<Double> function, ConnectingConsumer<Double>... consumers) {
    return new DoWhileLoop<>(function, DoublePredicates.isMoreThen(exclusiveBoundary).negate(), List.of(consumers));
  }

  @SafeVarargs
  public static Loop<Integer> untilReachingOrFallingBelow(final int exclusiveBoundary, ConnectingUnaryOperator<Integer> function, ConnectingConsumer<Integer>... consumers) {
    return new DoWhileLoop<>(function, IntegerPredicates.isLessThenOrEqualTo(exclusiveBoundary), List.of(consumers));
  }

  @SafeVarargs
  public static Loop<Long> untilReachingOrFallingBelow(final long exclusiveBoundary, ConnectingUnaryOperator<Long> function, ConnectingConsumer<Long>... consumers) {
    return new DoWhileLoop<>(function, LongPredicates.isLessThenOrEqualTo(exclusiveBoundary), List.of(consumers));
  }

  @SafeVarargs
  public static Loop<Float> untilReachingOrFallingBelow(final float exclusiveBoundary, ConnectingUnaryOperator<Float> function, ConnectingConsumer<Float>... consumers) {
    return new DoWhileLoop<>(function, FloatPredicates.isLessThenOrEqualTo(exclusiveBoundary), List.of(consumers));
  }

  @SafeVarargs
  public static Loop<Double> untilReachingOrFallingBelow(final double exclusiveBoundary, ConnectingUnaryOperator<Double> function, ConnectingConsumer<Double>... consumers) {
    return new DoWhileLoop<>(function, DoublePredicates.isLessThenOrEqualTo(exclusiveBoundary), List.of(consumers));
  }

  @SafeVarargs
  public static Loop<Integer> untilGoingAbove(final int inclusiveBoundary, ConnectingUnaryOperator<Integer> function, ConnectingConsumer<Integer>... consumers) {
    return new DoWhileLoop<>(function, IntegerPredicates.isMoreThenOrEqualTo(inclusiveBoundary).negate(), List.of(consumers));
  }

  @SafeVarargs
  public static Loop<Long> untilGoingAbove(final long inclusiveBoundary, ConnectingUnaryOperator<Long> function, ConnectingConsumer<Long>... consumers) {
    return new DoWhileLoop<>(function, LongPredicates.isMoreThenOrEqualTo(inclusiveBoundary).negate(), List.of(consumers));
  }

  @SafeVarargs
  public static Loop<Float> untilGoingAbove(final float inclusiveBoundary, ConnectingUnaryOperator<Float> function, ConnectingConsumer<Float>... consumers) {
    return new DoWhileLoop<>(function, FloatPredicates.isMoreThenOrEqualTo(inclusiveBoundary).negate(), List.of(consumers));
  }

  @SafeVarargs
  public static Loop<Double> untilGoingAbove(final double inclusiveBoundary, ConnectingUnaryOperator<Double> function, ConnectingConsumer<Double>... consumers) {
    return new DoWhileLoop<>(function, DoublePredicates.isMoreThenOrEqualTo(inclusiveBoundary).negate(), List.of(consumers));
  }

  @SafeVarargs
  public static Loop<Integer> untilFallingBelow(final int inclusiveBoundary, ConnectingUnaryOperator<Integer> function, ConnectingConsumer<Integer>... consumers) {
    return new DoWhileLoop<>(function, IntegerPredicates.isLessThen(inclusiveBoundary), List.of(consumers));
  }

  @SafeVarargs
  public static Loop<Long> untilFallingBelow(final long inclusiveBoundary, ConnectingUnaryOperator<Long> function, ConnectingConsumer<Long>... consumers) {
    return new DoWhileLoop<>(function, LongPredicates.isLessThen(inclusiveBoundary), List.of(consumers));
  }

  @SafeVarargs
  public static Loop<Float> untilFallingBelow(final float inclusiveBoundary, ConnectingUnaryOperator<Float> function, ConnectingConsumer<Float>... consumers) {
    return new DoWhileLoop<>(function, FloatPredicates.isLessThen(inclusiveBoundary), List.of(consumers));
  }

  @SafeVarargs
  public static Loop<Double> untilFallingBelow(final double inclusiveBoundary, ConnectingUnaryOperator<Double> function, ConnectingConsumer<Double>... consumers) {
    return new DoWhileLoop<>(function, DoublePredicates.isLessThen(inclusiveBoundary), List.of(consumers));
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

//  public static <T> Operation<T> then(ConnectingUnaryOperator<T> function) {
//    return new WhileLoopOperation<>(function);
//  }
//
//  public static <T> Operation<T> then(ConnectingUnaryOperator<T> function, Predicate<T> predicate) {
//    return new WhileLoopOperation<>(function, predicate);
//  }
}
