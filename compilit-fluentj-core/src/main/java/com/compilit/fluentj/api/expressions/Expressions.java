package com.compilit.fluentj.api.expressions;

import com.compilit.fluentj.api.predicates.Predicates;
import com.compilit.validation.api.contracts.Rule;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static com.compilit.fluentj.api.predicates.Predicates.itIsAnythingElse;

public class Expressions {

  private Expressions() {
  }

  public static <T, R> Expression<T, R> matchesThat(Predicate<T> predicate, R returnValue) {
    return new SupplierExpression<>(predicate, () -> returnValue, true);
  }

  public static <T, R> Expression<T, Void> matchesThat(Predicate<T> predicate, Runnable runnable) {
    return new RunnableExpression<>(predicate, runnable, null);
  }

  public static <T, R> Expression<T, Void> matchesThat(Predicate<T> predicate, Consumer<T> consumer) {
    return new ConsumerExpression<>(predicate, consumer, null);
  }

  public static <T, R> Expression<T, Void> matchesThat(Predicate<T> predicate, Runnable runnable, SwitchBreaker<T, Void> switchBreaker) {
    return new RunnableExpression<>(predicate, runnable, switchBreaker);
  }

  public static <T, R> Expression<T, Void> matchesThat(Predicate<T> predicate, Consumer<T> consumer, SwitchBreaker<T, Void> switchBreaker) {
    return new ConsumerExpression<>(predicate, consumer, switchBreaker);
  }

  public static <T, R> Expression<T, R> isNull(Supplier<R> supplier) {
    return new SupplierExpression<>(Predicates.isNull(), supplier, false);
  }

  public static <T> Expression<T, Void> isNull(Runnable runnable) {
    return new RunnableExpression<>(Predicates.isNull(), runnable, null);
  }

  public static <T, R> Expression<T, Void> isNull(Consumer<T> consumer) {
    return new ConsumerExpression<>(Predicates.isNull(), consumer, null);
  }

  public static <T, R> Expression<T, R> isNull(Function<T, R> function) {
    return new FunctionExpression<>(Predicates.isNull(), function, false);
  }

  public static <T, R> Expression<T, R> isNotNull(Supplier<R> supplier) {
    return new SupplierExpression<>(Predicates.isNotNull(), supplier, true);
  }

  public static <T, R> Expression<T, Void> isNotNull(Runnable runnable) {
    return new RunnableExpression<>(Predicates.isNotNull(), runnable, null);
  }

  public static <T, R> Expression<T, Void> isNotNull(Consumer<T> consumer) {
    return new ConsumerExpression<>(Predicates.isNotNull(), consumer, null);
  }

  public static <T, R> Expression<T, R> isNotNull(Function<T, R> function) {
    return new FunctionExpression<>(Predicates.isNotNull(), function, false);
  }

  public static <T, R> Expression<T, R> compliesWith(Rule<T> rule, Supplier<R> returnValue) {
    return new SupplierExpression<>(rule, returnValue, false);
  }

  public static <T> Expression<T, Void> compliesWith(Rule<T> rule, Runnable runnable) {
    return new RunnableExpression<>(rule, runnable, null);
  }

  public static <T> Expression<T, Void> compliesWith(Rule<T> rule, Consumer<T> consumer) {
    return new ConsumerExpression<>(rule, consumer, null);
  }

  public static <T, R> Expression<T, R> compliesWith(Rule<T> rule, Function<T, R> function) {
    return new FunctionExpression<>(rule, function, false);
  }

  public static <T> Expression<T, Void> compliesWith(Rule<T> rule, Runnable runnable, SwitchBreaker<T, Void> switchBreaker) {
    return new RunnableExpression<>(rule, runnable, switchBreaker);
  }

  public static <T> Expression<T, Void> compliesWith(Rule<T> rule, Consumer<T> consumer, SwitchBreaker<T, Void> switchBreaker) {
    return new ConsumerExpression<>(rule, consumer, switchBreaker);
  }

  public static <T, R> Expression<T, R> is(T value, Supplier<R> returnValue) {
    return new SupplierExpression<>(Predicates.is(value), returnValue, false);
  }

  public static <T> Expression<T, Void> is(T value, Runnable runnable) {
    return new RunnableExpression<>(Predicates.is(value), runnable, null);
  }

  public static <T> Expression<T, Void> is(T value, Consumer<T> consumer) {
    return new ConsumerExpression<>(Predicates.is(value), consumer, null);
  }

  public static <T> Expression<T, Void> is(T value, Consumer<T> consumer, SwitchBreaker<T, Void> switchBreaker) {
    return new ConsumerExpression<>(Predicates.is(value), consumer, switchBreaker);
  }

  public static <T> Expression<T, Void> is(T value, Runnable runnable, SwitchBreaker<T, Void> switchBreaker) {
    return new RunnableExpression<>(Predicates.is(value), runnable, switchBreaker);
  }

  public static <T, R> Expression<T, R> is(T value, Function<T, R> function) {
    return new FunctionExpression<>(Predicates.is(value), function, false);
  }

  public static <T, R> Expression<T, R> otherwiseReturn(R defaultValue) {
    return new SupplierExpression<>(itIsAnythingElse(), () -> defaultValue, true);
  }

  public static <T> Expression<T, Void> otherwise(Runnable defaultRunnable) {
    return new RunnableExpression<>(itIsAnythingElse(), defaultRunnable, null);
  }

  public static <T> Expression<T, Void> otherwise(Consumer<T> defaultConsumer) {
    return new ConsumerExpression<>(itIsAnythingElse(), defaultConsumer, null);
  }

  public static <T, R> Expression<T, R> otherwise(Function<T, R> defaultFunction) {
    return new FunctionExpression<>(itIsAnythingElse(), defaultFunction, true);
  }

}
