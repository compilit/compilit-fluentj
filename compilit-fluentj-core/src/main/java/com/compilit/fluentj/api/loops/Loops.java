package com.compilit.fluentj.api.loops;

import com.compilit.fluentj.api.expressions.Expression;
import com.compilit.fluentj.api.operations.ConnectingConsumer;
import com.compilit.fluentj.api.operations.ConnectingFunction;
import com.compilit.fluentj.api.operations.ConnectingUnaryOperator;
import com.compilit.fluentj.api.operations.ContinuingConsumer;
import com.compilit.fluentj.api.operations.ContinuingFunction;
import com.compilit.results.Result;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public final class Loops {
  private Loops() {
  }

//  public static <T> void startingWith(T input, Loop<T> loop, ConnectingConsumer<T> consumer) {
//    loop.setInput(input);
//    loop.addConsumers(Collections.singletonList(consumer));
//    loop.resolveAll();
//  }

  public static <T> void startingWith(T input, Loop<T> loop, ContinuingConsumer<T> consumer) {
    loop.setInput(input);
    consumer.accept(loop.resolveAll());
  }

  public static <T> void startingWithA(T input, Loop<T> loop, ContinuingConsumer<T> consumer) {
    startingWith(input, loop, consumer);
  }

  public static <T> void startingWithAn(T input, Loop<T> loop, ContinuingConsumer<T> consumer) {
    startingWith(input, loop, consumer);
  }

  public static <T> Result<T> startingWith(T input, Loop<T> loop, ContinuingFunction<Loop<T>, Result<T>> function) {
    loop.setInput(input);
    return function.apply(loop);
  }

  public static <T> Result<T> startingWithA(T input, Loop<T> loop, ContinuingFunction<Loop<T>, Result<T>> function) {
    return startingWith(input, loop, function);
  }

  public static <T> Result<T> startingWithAn(T input, Loop<T> loop, ContinuingFunction<Loop<T>, Result<T>> function) {
    return startingWith(input, loop, function);
  }

  public static <T> void startingWith(T input, Loop<T> loop, ConnectingConsumer<T> consumer) {
    consumer.accept(input);
  }

  public static <T> void startingWithA(T input, Loop<T> loop, ConnectingConsumer<T> consumer) {
    startingWith(input,loop, consumer);
  }

  public static <T> void startingWithAn(T input, Loop<T> loop, ConnectingConsumer<T> consumer) {
    startingWith(input,loop, consumer);
  }

  //  public static <T> Result<T> startingWith(T input, Loop<T> loop, ConnectingConsumer<T> intermittentConsumer, ContinuingFunction<Loop<T>, Result<T>> function) {
//    loop.addConsumers(Collections.singletonList(intermittentConsumer));
//    loop.setInput(input);
//    return function.apply(loop);
//  }

  public static <T> T startingWith(T input, Loop<T> loop) {
    loop.setInput(input);
    return loop.resolveAll();
  }

  public static <T> T startingWithA(T input, Loop<T> loop) {
    return startingWith(input, loop);
  }

  public static <T> T startingWithAn(T input, Loop<T> loop) {
    return startingWith(input, loop);
  }

  public static <T, R> boolean tryStartingWith(T input, Loop<T> loop, Predicate<T> predicate) {
    loop.setInput(input);
    loop.addInterrupter(predicate);
    loop.resolveAll();
    return !loop.isInterrupted();
  }

  public static <T> void takeEachEntryIn(Collection<T> collection, ConnectingConsumer<T> consumer) {
    collection.forEach(consumer);
  }

  public static <T, R> R takeEachEntryIn(Collection<T> collection, Expression<T, R> expression) {
    for (var entry : collection) {
      var result = expression.apply(entry);
      if (result != null)
        return result;
    }
    return null;
  }

//  public static <T> void forEachEntryIn(Collection<T> collection, ConnectingConsumer<T> consumer) {
//    collection.forEach(consumer);
//  }

//  public static <T> Collection<T> eachEntryIn(Collection<T> collection) {
//    return collection;
//  }

  public static <T> ConnectingUnaryOperator<Collection<T>> eachEntry(Predicate<T> predicate) {
    return collection -> collection.stream().filter(predicate).collect(Collectors.toList());
  }

}
