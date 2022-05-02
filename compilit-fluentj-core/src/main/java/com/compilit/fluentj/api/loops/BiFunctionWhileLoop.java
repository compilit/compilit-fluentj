package com.compilit.fluentj.api.loops;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

class BiFunctionWhileLoop<T> extends AbstractLoop<T> implements Loop<T> {

  private final BiFunction<T, T, T> biFunction;

  protected BiFunctionWhileLoop(BiFunction<T, T, T> biFunction, List<Consumer<T>> consumerList) {
    super();
    this.biFunction = biFunction;
    this.consumers.addAll(consumerList);
  }

  protected BiFunctionWhileLoop(BiFunction<T, T, T> biFunction, Predicate<T> predicate, List<Consumer<T>> consumerList) {
    super();
    this.mainPredicate = predicate;
    this.biFunction = biFunction;
    this.consumers.addAll(consumerList);
  }

  @Override
  public T resolveAll() {
    if (!consumers.isEmpty())
      return resolveAllWithIntermittentOperation();
    while (mainPredicate.test(input)) {
      input = biFunction.apply(input, input);
      if (interrupter.test(input)) {
        isInterrupted = true;
        break;
      }
    }
    return input;
  }

  @Override
  public void apply(Predicate<T> predicate, Consumer<T> consumer) {
    var previous = input;
    var current = input;
    while (!mainPredicate.test(current)) {
      var tmp = current;
      current = biFunction.apply(previous, current);
      previous = tmp;
      if (predicate.test(current)) {
        consumer.accept(current);
      }
    }
  }

  private T resolveAllWithIntermittentOperation() {
    var previous = input;
    while (!mainPredicate.test(input)) {
      consumers.forEach(x -> x.accept(input));
      var tmp = input;
      input = biFunction.apply(previous, input);
      previous = tmp;
      if (interrupter.test(input)) {
        isInterrupted = true;
        break;
      }
    }
    return input;
  }

}
