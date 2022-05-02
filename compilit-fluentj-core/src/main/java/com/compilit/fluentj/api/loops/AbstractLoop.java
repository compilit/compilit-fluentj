package com.compilit.fluentj.api.loops;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

abstract class AbstractLoop<T> implements Loop<T> {

  protected final List<Consumer<T>> consumers = new ArrayList<>();
  protected boolean isInterrupted;
  protected Predicate<T> interrupter = x -> false;
  protected Predicate<T> mainPredicate;
  protected UnaryOperator<T> mainUnaryOperator;

  protected T input;

  protected AbstractLoop() {
  }

  @Override
  public void resolveAllAndThen(Consumer<T> consumer) {
    var result = resolveAll();
    consumer.accept(result);
  }

  @Override
  public boolean isInterrupted() {
    return isInterrupted;
  }

  @Override
  public T insertAndResolveAll(T input, List<Consumer<T>> consumers) {
    setInput(input);
    this.consumers.addAll(consumers);
    return resolveAll();
  }

  @Override
  public void setInput(T input) {
    this.input = input;
  }

  @Override
  public void addConsumers(List<Consumer<T>> consumers) {
    this.consumers.addAll(consumers);
  }

  @Override
  public void addPredicate(Predicate<T> predicate) {
    this.mainPredicate = predicate;
  }

  @Override
  public void addMainUnaryOperator(UnaryOperator<T> mainUnaryOperator) {
    this.mainUnaryOperator = mainUnaryOperator;
  }

  @Override
  public void addInterrupter(Predicate<T> predicate) {
    this.interrupter = predicate;
  }

}
