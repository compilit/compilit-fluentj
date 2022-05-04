package com.compilit.fluentj.api.expressions;

class RunnableSwitchBreaker<T> implements SwitchBreaker<T, Void> {

  private final Runnable runnable;

  public RunnableSwitchBreaker(Runnable runnable) {
    this.runnable = runnable;
  }

  @Override
  public Void apply(T input) {
    runnable.run();
    return null;
  }
}
