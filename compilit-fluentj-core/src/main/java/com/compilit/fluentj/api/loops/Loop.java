package com.compilit.fluentj.api.loops;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public interface Loop<T> {

  void resolveAllAndThen(Consumer<T> consumer);

  T resolveAll();

  boolean isInterrupted();

  void apply(Predicate<T> predicate, Consumer<T> consumer);

  T insertAndResolveAll(T input, List<Consumer<T>> consumers);

  void setInput(T input);

  void addConsumers(List<Consumer<T>> consumerList);

  void addPredicate(Predicate<T> predicate);

  void addMainUnaryOperator(UnaryOperator<T> unaryOperator);

  void addInterrupter(Predicate<T> predicate);


}
