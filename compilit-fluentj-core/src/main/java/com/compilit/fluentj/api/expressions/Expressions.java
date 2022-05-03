package com.compilit.fluentj.api.expressions;

import com.compilit.fluentj.api.operations.ConnectingConsumer;
import com.compilit.fluentj.api.operations.ConnectingRunnable;
import com.compilit.fluentj.api.operations.ConnectingFunction;
import com.compilit.fluentj.api.predicates.Predicates;
import com.compilit.validation.api.contracts.Rule;

import java.util.function.Predicate;
import java.util.function.Supplier;

import static com.compilit.fluentj.api.predicates.Predicates.itIsAnythingElse;

public class Expressions {

  private Expressions() {
  }

  public static <T, R> Expression<T, R> isNull(Supplier<R> supplier) {
    return new SupplierExpression<>(Predicates.isNull(), supplier);
  }

  public static <T> Expression<T, Void> isNull(ConnectingRunnable runnable) {
    return new RunnableExpression<>(Predicates.isNull(), runnable);
  }

  public static <T, R> Expression<T, Void> isNull(ConnectingConsumer<T> consumer) {
    return new ConsumerExpression<>(Predicates.isNull(), consumer);
  }

  public static <T, R> Expression<T, R> isNull(ConnectingFunction<T, R> function) {
    return new FunctionExpression<>(Predicates.isNull(), function);
  }

  public static <T, R> Expression<T, R> isNotNull(Supplier<R> supplier) {
    return new SupplierExpression<>(Predicates.isNotNull(), supplier);
  }

  public static <T, R> Expression<T, Void> isNotNull(ConnectingRunnable runnable) {
    return new RunnableExpression<>(Predicates.isNotNull(), runnable);
  }

  public static <T, R> Expression<T, Void> isNotNull(ConnectingConsumer<T> consumer) {
    return new ConsumerExpression<>(Predicates.isNotNull(), consumer);
  }

  public static <T, R> Expression<T, R> isNotNull(ConnectingFunction<T, R> function) {
    return new FunctionExpression<>(Predicates.isNotNull(), function);
  }

//  public static <T, R> Expression<T, R> itIs(T value, Supplier<R> returnValue) {
//    return new SupplierExpression<>(Predicates.is(value), returnValue);
//  }

  public static <T, R> Expression<T, R> compliesWith(Rule<T> rule, Supplier<R> returnValue) {
    return new SupplierExpression<>(rule, returnValue);
  }

  public static <T> Expression<T, Void> compliesWith(Rule<T> rule, ConnectingRunnable runnable) {
    return new RunnableExpression<>(rule, runnable);
  }

  public static <T> Expression<T, Void> compliesWith(Rule<T> rule, ConnectingConsumer<T> consumer) {
    return new ConsumerExpression<>(rule, consumer);
  }


  public static <T, R> Expression<T, R> compliesWith(Rule<T> rule, ConnectingFunction<T, R> function) {
    return new FunctionExpression<>(rule, function);
  }

  public static <T, R> Expression<T, R> is(T value, Supplier<R> returnValue) {
    return new SupplierExpression<>(Predicates.is(value), returnValue);
  }

  public static <T> Expression<T, Void> is(T value, ConnectingRunnable runnable) {
    return new RunnableExpression<>(Predicates.is(value), runnable);
  }

  public static <T> Expression<T, Void> is(T value, ConnectingConsumer<T> consumer) {
    return new ConsumerExpression<>(Predicates.is(value), consumer);
  }

  public static <T, R> Expression<T, R> is(T value, ConnectingFunction<T, R> function) {
    return new FunctionExpression<>(Predicates.is(value), function);
  }

  public static <T, R> Expression<T, R> matchesThat(Predicate<T> predicate, R returnValue) {
    return new SupplierExpression<>(predicate, () -> returnValue);
  }

  public static <T, R> Expression<T, Void> matchesThat(Predicate<T> predicate, ConnectingRunnable runnable) {
    return new RunnableExpression<>(predicate, runnable);
  }

  public static <T, R> Expression<T, Void> matchesThat(Predicate<T> predicate, ConnectingConsumer<T> consumer) {
    return new ConsumerExpression<>(predicate, consumer);
  }

  public static <T, R> Expression<T, R> otherwiseReturn(R defaultValue) {
    return new SupplierExpression<>(itIsAnythingElse(), () -> defaultValue, true);
  }

  public static <T, R> Expression<T, Void> otherwise(ConnectingRunnable defaultRunnable) {
    return new RunnableExpression<>(itIsAnythingElse(), defaultRunnable);
  }

  public static <T, R> Expression<T, Void> otherwise(ConnectingConsumer<T> defaultConsumer) {
    return new ConsumerExpression<>(itIsAnythingElse(), defaultConsumer);
  }

  public static <T, R> Expression<T, R> otherwise(ConnectingFunction<T, R> defaultFunction) {
    return new FunctionExpression<>(itIsAnythingElse(), defaultFunction, true);
  }

}
