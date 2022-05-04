package com.compilit.fluentj.api.expressions;

import java.util.function.Consumer;
import java.util.function.Function;

class ConsumerSwitchBreaker<T> implements SwitchBreaker<T, Void> {

  private final Consumer<T> consumer;

  public ConsumerSwitchBreaker(Consumer<T> consumer) {
    this.consumer = consumer;
  }


  @Override
  public Void apply(T input) {
     consumer.accept(input);
     return null;
  }

}
