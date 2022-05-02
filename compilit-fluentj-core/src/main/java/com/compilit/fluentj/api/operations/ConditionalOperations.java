package com.compilit.fluentj.api.operations;

import java.util.function.Consumer;

public class ConditionalOperations {

  public static ContinuingRunnable then(ConnectingRunnable runnable) {
    return runnable::run;
  }

  public static <T> ContinuingConsumer<T> then(ConnectingConsumer<T> consumer) {
    return consumer::accept;
  }

}
