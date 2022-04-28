package com.compilit.fluentj.api.expressions;

import java.util.function.Consumer;
import java.util.function.Predicate;

class ConsumerExpression<T> extends AbstractExpression<T, Void> implements Expression<T, Void> {
  private final Consumer<T> consumer;

  public ConsumerExpression(Predicate<T> predicate, Consumer<T> consumer) {
    super(predicate, true);
    this.consumer = consumer;
  }

  @Override
  public Void apply(T input) {
    if (predicate.test(input))
      consumer.accept(input);
    if (next != null)
      return next.apply(input);
    return null;
  }

}
