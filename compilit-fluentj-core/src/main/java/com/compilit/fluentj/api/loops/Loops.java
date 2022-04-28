package com.compilit.fluentj.api.loops;

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

  public static <T> void startingWith(T input, Loop<T> loop, Consumer<T> consumer) {
    loop.insertAndResolveAll(input, Collections.singletonList(consumer));
  }

  public static <T> void startingWithA(T input, Loop<T> loop, Consumer<T> consumer) {
     startingWith(input, loop, consumer);
  }

  public static <T> void startingWithAn(T input, Loop<T> loop, Consumer<T> consumer) {
    startingWith(input, loop, consumer);
  }

  public static <T> Result<T> startingWith(T input, Loop<T> loop, Function<Loop<T>, Result<T>> function) {
    loop.setInput(input);
    return function.apply(loop);
  }

  public static <T> Result<T> startingWithA(T input, Loop<T> loop, Function<Loop<T>, Result<T>> function) {
    return startingWith(input, loop, function);
  }

  public static <T> Result<T> startingWithAn(T input, Loop<T> loop, Function<Loop<T>, Result<T>> function) {
    return startingWith(input, loop, function);
  }

  public static <T> void startingWith(T input, Consumer<T> consumer) {
    consumer.accept(input);
  }


  public static <T> void startingWithA(T input, Consumer<T> consumer) {
    startingWith(input, consumer);
  }

  public static <T> void startingWithAn(T input, Consumer<T> consumer) {
    startingWith(input, consumer);
  }

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

  public static <T> boolean tryStartingWith(T input, Loop<T> loop, Predicate<T> predicate) {
    loop.setInput(input);
    loop.addInterrupter(predicate);
    loop.resolveAll();
    return !loop.isInterrupted();
  }

  public static <T> void takeEachEntryIn(Collection<T> collection, Consumer<T> consumer) {
    collection.forEach(consumer);
  }

  public static <T> void forEachEntryIn(Collection<T> collection, Consumer<T> consumer) {
    collection.forEach(consumer);
  }

  public static <T> Collection<T> eachEntryIn(Collection<T> collection) {
    return collection;
  }

  public static <T> UnaryOperator<Collection<T>> eachEntry(Predicate<T> predicate) {
    return collection -> collection.stream().filter(predicate).collect(Collectors.toList());
  }

}
