package com.compilit.fluentj.api.loops;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

class DoWhileLoop<T> extends AbstractLoop<T> implements Loop<T> {

  public DoWhileLoop(UnaryOperator<T> mainUnaryOperator, Predicate<T> predicate, List<Consumer<T>> consumerList) {
    super();
    this.mainPredicate = predicate;
    this.mainUnaryOperator = mainUnaryOperator;
    this.consumers.addAll(consumerList);
  }

  @Override
  public T resolveAll() {
    if (!consumers.isEmpty())
      return resolveAllWithIntermittentOperation();
    do {
      input = mainUnaryOperator.apply(input);
      if (interrupter.test(input)) {
        isInterrupted = true;
        break;
      }
    }
    while (mainPredicate.test(input) && !interrupter.test(input));
    return input;
  }

  @Override
  public void apply(Predicate<T> predicate, Consumer<T> consumer) {
    var current = input;
    while (mainPredicate.test(current)) {
      current = mainUnaryOperator.apply(current);
      if (predicate.test(current)) {
        consumer.accept(current);
      }
    }
  }

  private T resolveAllWithIntermittentOperation() {
    do {
      consumers.forEach(x -> x.accept(input));
      input = mainUnaryOperator.apply(input);
      if (interrupter.test(input)) {
        isInterrupted = true;
        break;
      }
    }
    while (mainPredicate.test(input));
    return input;
  }

}
