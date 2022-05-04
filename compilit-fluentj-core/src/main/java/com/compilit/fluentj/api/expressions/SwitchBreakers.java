package com.compilit.fluentj.api.expressions;

import java.util.function.Consumer;
import java.util.function.Function;

public final class SwitchBreakers {

  private SwitchBreakers() {}

  public static <T> SwitchBreaker<T, Void> andThenReturn() {
    return new SupplierSwitchBreaker<>(() -> null);
  }

  public static <T> SwitchBreaker<T, Void> andThenReturnAfterApplying(Runnable runnable) {
    return new RunnableSwitchBreaker<>(runnable);
  }

  public static <T> SwitchBreaker<T, Void> andThenReturnAfterApplying(Consumer<T> consumer) {
    return new ConsumerSwitchBreaker<>(consumer);
  }

}
