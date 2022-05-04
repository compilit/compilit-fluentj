package com.compilit.fluentj.api.operations;

import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

public final class LoggerOperations {
  private LoggerOperations() {
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
