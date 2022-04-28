package com.compilit.fluentj.api.operations;

import java.util.function.Consumer;

public class ConditionalOperations {

  public static Runnable then(Runnable runnable) {
    return runnable;
  }

  public static <T> Consumer<T> then(Consumer<T> consumer) {
    return consumer;
  }

}
