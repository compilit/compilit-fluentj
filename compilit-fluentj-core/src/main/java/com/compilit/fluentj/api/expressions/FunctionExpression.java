package com.compilit.fluentj.api.expressions;

import com.compilit.fluentj.exceptions.IncompleteExpressionException;

import java.util.function.Function;
import java.util.function.Predicate;

class FunctionExpression<T, R> implements Expression<T, R> {

  private final Predicate<T> predicate;
  private final Function<T, R> function;
  private Expression<T, R> next;
  private boolean isComplete;

  public FunctionExpression(Predicate<T> predicate, Function<T, R> function) {
    this.predicate = predicate;
    this.function = function;
    this.isComplete = false;
  }

  public FunctionExpression(Predicate<T> predicate, Function<T, R> function, boolean isComplete) {
    this.predicate = predicate;
    this.function = function;
    this.isComplete = isComplete;
  }

  @Override
  public R apply(T input) {
    if (!isComplete)
      throw new IncompleteExpressionException();
    if (predicate.test(input))
      return function.apply(input);
    return next.apply(input);
  }

  @Override
  public boolean isComplete() {
    return isComplete || next != null && next.isComplete();
  }

  @Override
  public void append(Expression<T, R> next) {
    if (next.isComplete())
      this.isComplete = true;
    this.next = next;
  }
}
