package com.compilit.fluentj.api.expressions;

import java.util.function.Predicate;

abstract class AbstractExpression<T, R> implements Expression<T, R> {
  protected final Predicate<T> predicate;
  protected final boolean isComplete;
  protected Expression<T, R> next;

  protected AbstractExpression(Predicate<T> predicate, boolean isComplete) {
    this.predicate = predicate;
    this.isComplete = isComplete;
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

}
