package com.compilit.fluentj.api.expressions;

import java.util.function.Predicate;

class RunnableExpression<T> extends AbstractExpression<T, Void> implements Expression<T, Void> {

  private final Runnable runnable;

  public RunnableExpression(Predicate<T> predicate, Runnable runnable) {
    super(predicate, true);
    this.runnable = runnable;
  }

  @Override
  public Void apply(T input) {
    if (predicate.test(input)) {
      hasMatchedPredicate = true;
      runnable.run();
    }
    if (next != null)
      return next.apply(input);
    return null;
  }

}
