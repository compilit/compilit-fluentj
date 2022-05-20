package com.compilit.fluentj.api.expressions;

import java.util.function.Predicate;

class RunnableExpression<T> extends AbstractExpression<T, Void> implements Expression<T, Void> {

  private final Runnable runnable;
  private final SwitchBreaker<T, Void> switchBreaker;

  public RunnableExpression(Predicate<T> predicate, Runnable runnable, SwitchBreaker<T, Void> switchBreaker, boolean isDefault) {
    super(predicate, true, isDefault);
    this.runnable = runnable;
    this.switchBreaker = switchBreaker;
  }

  @Override
  public Void apply(T input, boolean hasMatchedPredicate) {
    if (isDefaultNonComplying(input, hasMatchedPredicate)) {
      runnable.run();
      return null;
    }
    if (isFinalAndComplying(input)) {
      runnable.run();
      return null;
    }
    if (next != null) {
      if (predicate.test(input)) {
        hasMatchedPredicate = true;
        runnable.run();
        if (switchBreaker != null) {
          return switchBreaker.apply(input);
        }
      }
      return next.apply(input, hasMatchedPredicate);
    }
    return null;
  }

}
