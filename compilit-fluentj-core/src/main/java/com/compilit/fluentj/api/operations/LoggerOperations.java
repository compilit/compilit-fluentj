package com.compilit.fluentj.api.operations;

import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public final class LoggerOperations {
  private LoggerOperations() {
  }

  public static <T> ConnectingConsumer<T> printIt() {
    return System.out::println;
  }

  public static ConnectingRunnable print(final String message) {
    return () -> System.out.println(message);
  }

  public static ConnectingRunnable debugLog(final String message) {
    return () -> LoggerFactory.getLogger(LoggerOperations.class).debug(message);
  }

  public static <T> ConnectingConsumer<T> debugLogIt() {
    return value -> LoggerFactory.getLogger(LoggerOperations.class).debug(value.toString());
  }

  public static ConnectingRunnable infoLog(final String message) {
    return () -> LoggerFactory.getLogger(LoggerOperations.class).info(message);
  }

  public static <T> ConnectingConsumer<T> infoLogIt() {
    return value -> LoggerFactory.getLogger(LoggerOperations.class).info(value.toString());
  }

  public static ConnectingRunnable warningLog(final String message) {
    return () -> LoggerFactory.getLogger(LoggerOperations.class).warn(message);
  }

  public static <T> ConnectingConsumer<T> warningLogIt() {
    return value -> LoggerFactory.getLogger(LoggerOperations.class).warn(value.toString());
  }

  public static ConnectingRunnable errorLog(final String message) {
    return () -> LoggerFactory.getLogger(LoggerOperations.class).error(message);
  }

  public static <T> ConnectingConsumer<T> errorLogIt() {
    return value -> LoggerFactory.getLogger(LoggerOperations.class).error(value.toString());
  }
}
