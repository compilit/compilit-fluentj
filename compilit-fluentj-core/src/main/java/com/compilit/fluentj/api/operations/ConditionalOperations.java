package com.compilit.fluentj.api.operations;

public class ConditionalOperations {

  public static ConnectingRunnable then(ConnectingRunnable runnable) {
    return runnable;
  }

  public static <T> ConnectingConsumer<T> then(ConnectingConsumer<T> consumer) {
    return consumer;
  }

}
