package com.compilit.fluentj.api.loops;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

class UnaryOperatorWhileLoop<T> extends AbstractLoop<T> implements Loop<T> {

  public UnaryOperatorWhileLoop(UnaryOperator<T> unaryOperator, Predicate<T> predicate) {
    super();
    this.mainPredicate = predicate;
    this.mainUnaryOperator = unaryOperator;
  }

  @Override
  public T resolveAll() {
    if (!consumers.isEmpty())
      return resolveAllWithIntermittentOperation();
    while (mainPredicate.test(input)) {
      if (interrupter.test(input)) {
        isInterrupted = true;
        break;
      }
      input = mainUnaryOperator.apply(input);
    }
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
    while (mainPredicate.test(input)) {
      if (interrupter.test(input)) {
        isInterrupted = true;
        break;
      }
      consumers.forEach(x -> x.accept(input));
      input = mainUnaryOperator.apply(input);
    }
    return input;
  }


}
