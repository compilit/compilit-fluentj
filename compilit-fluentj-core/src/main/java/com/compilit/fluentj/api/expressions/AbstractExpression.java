package com.compilit.fluentj.api.expressions;

import java.util.function.Predicate;

abstract class AbstractExpression<T, R> implements Expression<T, R> {
  protected final Predicate<T> predicate;
  protected final boolean isComplete;
  protected final boolean isDefault;

  protected Expression<T, R> next;

  protected AbstractExpression(Predicate<T> predicate, boolean isComplete, boolean isDefault) {
    this.predicate = predicate;
    this.isComplete = isComplete;
    this.isDefault = isDefault;
  }

  @Override
  public boolean isComplete() {
    return isComplete || next != null && next.isComplete();
  }

  @Override
  public void append(Expression<T, R> next) {
    if (this.next == null)
      this.next = next;
    else this.next.append(next);
  }

  protected boolean isFinalAndComplying(T input) {
    return !isDefault && next == null && predicate.test(input);
  }

  protected boolean isDefaultNonComplying(T input, boolean hasMatchedPredicate) {
    return isDefault && (!predicate.test(input) && !hasMatchedPredicate);
  }

}
