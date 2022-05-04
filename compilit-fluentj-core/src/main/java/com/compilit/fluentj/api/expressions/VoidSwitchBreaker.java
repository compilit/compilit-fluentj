package com.compilit.fluentj.api.expressions;

class VoidSwitchBreaker<T, R> implements SwitchBreaker<T, R> {

  public VoidSwitchBreaker() {
  }

  @Override
  public R apply(T input) {
    return null;
  }
}
