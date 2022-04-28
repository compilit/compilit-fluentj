package com.compilit.fluentj.api.loops;

import com.compilit.fluentj.api.predicates.LongPredicates;
import com.compilit.fluentj.api.predicates.DoublePredicates;
import com.compilit.fluentj.api.predicates.FloatPredicates;
import com.compilit.fluentj.api.predicates.IntegerPredicates;

import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public final class LoopOperations {

  private LoopOperations() {
  }

  //  public static <T> Operation<T> keep(UnaryOperator<T> unaryOperator) {
//    return new UnaryOperatorWhileLoopOperation<>(unaryOperator);
//  }
  public static <T> Loop<T> asLongAsIt(final Predicate<T> predicate, UnaryOperator<T> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, predicate);
  }

  public static Loop<Integer> untilReachingOrGoingAbove(final int exclusiveBoundary, UnaryOperator<Integer> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, IntegerPredicates.isMoreThen(exclusiveBoundary).negate());
  }

  public static Loop<Long> untilReachingOrGoingAbove(final long exclusiveBoundary, UnaryOperator<Long> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, LongPredicates.isMoreThen(exclusiveBoundary).negate());
  }

  public static Loop<Float> untilReachingOrGoingAbove(final float exclusiveBoundary, UnaryOperator<Float> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, FloatPredicates.isMoreThen(exclusiveBoundary).negate());
  }

  public static Loop<Double> untilReachingOrGoingAbove(final double exclusiveBoundary, UnaryOperator<Double> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, DoublePredicates.isMoreThen(exclusiveBoundary).negate());
  }

  public static Loop<Integer> untilReachingOrFallingBelow(final int exclusiveBoundary, UnaryOperator<Integer> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, IntegerPredicates.isLessThenOrEqualTo(exclusiveBoundary));
  }

  public static Loop<Long> untilReachingOrFallingBelow(final long exclusiveBoundary, UnaryOperator<Long> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, LongPredicates.isLessThenOrEqualTo(exclusiveBoundary));
  }

  public static Loop<Float> untilReachingOrFallingBelow(final float exclusiveBoundary, UnaryOperator<Float> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, FloatPredicates.isLessThenOrEqualTo(exclusiveBoundary));
  }

  public static Loop<Double> untilReachingOrFallingBelow(final double exclusiveBoundary, UnaryOperator<Double> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, DoublePredicates.isLessThenOrEqualTo(exclusiveBoundary));
  }

  public static Loop<Integer> untilGoingAbove(final int inclusiveBoundary, UnaryOperator<Integer> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, IntegerPredicates.isMoreThenOrEqualTo(inclusiveBoundary).negate());
  }

  public static Loop<Long> untilGoingAbove(final long inclusiveBoundary, UnaryOperator<Long> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, LongPredicates.isMoreThenOrEqualTo(inclusiveBoundary).negate());
  }

  public static Loop<Float> untilGoingAbove(final float inclusiveBoundary, UnaryOperator<Float> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, FloatPredicates.isMoreThenOrEqualTo(inclusiveBoundary).negate());
  }

  public static Loop<Double> untilGoingAbove(final double inclusiveBoundary, UnaryOperator<Double> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, DoublePredicates.isMoreThenOrEqualTo(inclusiveBoundary).negate());
  }

  public static Loop<Integer> untilFallingBelow(final int inclusiveBoundary, UnaryOperator<Integer> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, IntegerPredicates.isLessThen(inclusiveBoundary));
  }

  public static Loop<Long> untilFallingBelow(final long inclusiveBoundary, UnaryOperator<Long> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, LongPredicates.isLessThen(inclusiveBoundary));
  }

  public static Loop<Float> untilFallingBelow(final float inclusiveBoundary, UnaryOperator<Float> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, FloatPredicates.isLessThen(inclusiveBoundary));
  }

  public static Loop<Double> untilFallingBelow(final double inclusiveBoundary, UnaryOperator<Double> unaryOperator) {
    return new UnaryOperatorWhileLoop<>(unaryOperator, DoublePredicates.isLessThen(inclusiveBoundary));
  }


  public static <T> Loop<T> keep(UnaryOperator<T> unaryOperator, Predicate<T> predicate) {
    return new UnaryOperatorDoWhileLoop<>(unaryOperator, predicate);
  }

  public static <T> Loop<T> keep(BiFunction<T, T, T> biFunction) {
    return new BiFunctionWhileLoop<>(biFunction);
  }

  public static <T> Loop<T> keep(BiFunction<T, T, T> biFunction, Predicate<T> predicate) {
    return new BiFunctionWhileLoop<>(biFunction, predicate.negate());
  }

  public static <T> UnaryOperator<T> keep(UnaryOperator<T> unaryOperator) {
    return unaryOperator;
  }

//  public static <T> Operation<T> then(UnaryOperator<T> unaryOperator) {
//    return new UnaryOperatorWhileLoopOperation<>(unaryOperator);
//  }
//
//  public static <T> Operation<T> then(UnaryOperator<T> unaryOperator, Predicate<T> predicate) {
//    return new UnaryOperatorWhileLoopOperation<>(unaryOperator, predicate);
//  }
}
