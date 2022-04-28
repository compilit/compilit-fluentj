package com.compilit.fluentj.api.operations;

import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public final class LoggerOperations {
  private LoggerOperations() {
  }

  public static <T> Consumer<T> print(final UnaryOperator<T> unaryOperator) {
    return unaryOperator::apply;
  }

  public static <T> void print(final Collection<T> collection, Predicate<T> predicate) {
    collection.forEach(x -> {
      if (predicate.test(x))
        print(x.toString()).run();
    });
  }

  public static void debugLog(final Collection<?> collection) {
    collection.forEach(debugLogIt());
  }

  public static <T> void debugLog(final Collection<T> collection, Predicate<T> predicate) {
    collection.forEach(x -> {
      if (predicate.test(x))
        debugLog(x.toString()).run();
    });
  }

  public static void infoLog(final Collection<?> collection) {
    collection.forEach(infoLogIt());
  }

  public static <T> void infoLog(final Collection<T> collection, Predicate<T> predicate) {
    collection.forEach(x -> {
      if (predicate.test(x))
        infoLog(x.toString()).run();
    });
  }

  public static void warningLog(final Collection<?> collection) {
    collection.forEach(warningLogIt());
  }

  public static <T> void warningLog(final Collection<T> collection, Predicate<T> predicate) {
    collection.forEach(x -> {
      if (predicate.test(x))
        warningLog(x.toString()).run();
    });
  }

  public static void errorLog(final Collection<?> collection) {
    collection.forEach(errorLogIt());
  }

  public static <T> void errorLog(final Collection<T> collection, Predicate<T> predicate) {
    collection.forEach(x -> {
      if (predicate.test(x))
        errorLog(x.toString()).run();
    });
  }

  public static <T> Consumer<T> printIt() {
    return System.out::println;
  }

  public static Runnable print(final String message) {
    return () -> System.out.println(message);
  }

  public static Runnable debugLog(final String message) {
    return () -> LoggerFactory.getLogger(LoggerOperations.class).debug(message);
  }

  public static <T> Consumer<T> debugLogIt() {
    return value -> LoggerFactory.getLogger(LoggerOperations.class).debug(value.toString());
  }

  public static Runnable infoLog(final String message) {
    return () -> LoggerFactory.getLogger(LoggerOperations.class).info(message);
  }

  public static <T> Consumer<T> infoLogIt() {
    return value -> LoggerFactory.getLogger(LoggerOperations.class).info(value.toString());
  }

  public static Runnable warningLog(final String message) {
    return () -> LoggerFactory.getLogger(LoggerOperations.class).warn(message);
  }

  public static <T> Consumer<T> warningLogIt() {
    return value -> LoggerFactory.getLogger(LoggerOperations.class).warn(value.toString());
  }

  public static Runnable errorLog(final String message) {
    return () -> LoggerFactory.getLogger(LoggerOperations.class).error(message);
  }

  public static <T> Consumer<T> errorLogIt() {
    return value -> LoggerFactory.getLogger(LoggerOperations.class).error(value.toString());
  }
}
