package com.compilit.fluentj.api.expressions;

import com.compilit.fluentj.api.predicates.Predicates;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static com.compilit.fluentj.api.predicates.Predicates.isAnythingElse;

public class Expressions {

  private Expressions() {
  }

  public static <T> Expression<T, Void> isNull(Runnable runnable) {
    return new RunnableExpression<>(Predicates.isNull(), runnable);
  }

  public static <T, R> Expression<T, Void> isNull(Consumer<T> consumer) {
    return new ConsumerExpression<>(Predicates.isNull(), consumer);
  }

  public static <T, R> Expression<T, R> isNull(Function<T, R> function) {
    return new FunctionExpression<>(Predicates.isNull(), function);
  }

  public static <T, R> Expression<T, Void> isNotNull(Runnable runnable) {
    return new RunnableExpression<>(Predicates.isNotNull(), runnable);
  }

  public static <T, R> Expression<T, Void> isNotNull(Consumer<T> consumer) {
    return new ConsumerExpression<>(Predicates.isNotNull(), consumer);
  }

  public static <T, R> Expression<T, R> isNotNull(Function<T, R> function) {
    return new FunctionExpression<>(Predicates.isNotNull(), function);
  }

  public static <T, R> Expression<T, R> is(T value, Supplier<R> returnValue) {
    return new SupplierExpression<>(Predicates.is(value), returnValue);
  }

  public static <T> Expression<T, Void> is(T value, Runnable runnable) {
    return new RunnableExpression<>(Predicates.is(value), runnable);
  }

  public static <T> Expression<T, Void> is(T value, Consumer<T> consumer) {
    return new ConsumerExpression<>(Predicates.is(value), consumer);
  }

  public static <T, R> Expression<T, R> is(T value, Function<T, R> function) {
    return new FunctionExpression<>(Predicates.is(value), function);
  }

  public static <T, R> Expression<T, R> matchesThatIt(Predicate<T> predicate, R returnValue) {
    return new SupplierExpression<>(predicate, () -> returnValue);
  }

  public static <T, R> Expression<T, Void> matchesThatIt(Predicate<T> predicate, Runnable runnable) {
    return new RunnableExpression<>(predicate, runnable);
  }

  public static <T, R> Expression<T, Void> matchesThatIt(Predicate<T> predicate, Consumer<T> consumer) {
    return new ConsumerExpression<>(predicate, consumer);
  }

  public static <T, R> Expression<T, R> isAnyThingElseThenReturn(R defaultValue) {
    return new SupplierExpression<>(isAnythingElse(), () -> defaultValue, true);
  }

  public static <T, R> Expression<T, Void> isAnyThingElseThen(Runnable defaultRunnable) {
    return new RunnableExpression<>(isAnythingElse(), defaultRunnable);
  }

  public static <T, R> Expression<T, Void> isAnyThingElseThen(Consumer<T> defaultConsumer) {
    return new ConsumerExpression<>(isAnythingElse(), defaultConsumer);
  }

  public static <T, R> Expression<T, R> isAnyThingElseThen(Function<T, R> defaultFunction) {
    return new FunctionExpression<>(isAnythingElse(), defaultFunction, true);
  }

}
