package com.compilit.fluentj.api.expressions;

import java.util.function.Consumer;
import java.util.function.Predicate;

class ConsumerExpression<T> extends AbstractExpression<T, Void> implements Expression<T, Void> {
  private final Consumer<T> consumer;
  private final SwitchBreaker<T, Void> switchBreaker;

  public ConsumerExpression(Predicate<T> predicate, Consumer<T> consumer, SwitchBreaker<T, Void> switchBreaker) {
    super(predicate, true);
    this.consumer = consumer;
    this.switchBreaker = switchBreaker;
  }

  @Override
  public Void apply(T input, boolean hasMatchedPredicate) {
    if (next == null && !hasMatchedPredicate) {
      consumer.accept(input);
      return null;
    }
    if (next != null) {
      if (predicate.test(input)) {
        hasMatchedPredicate = true;
        consumer.accept(input);
        if (switchBreaker != null) {
          return switchBreaker.apply(input);
        }
      }
      return next.apply(input, hasMatchedPredicate);
    }
    return null;
  }

}
