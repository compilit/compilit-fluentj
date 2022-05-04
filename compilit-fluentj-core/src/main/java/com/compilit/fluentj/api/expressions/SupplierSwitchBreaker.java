package com.compilit.fluentj.api.expressions;

import java.util.function.Supplier;

class SupplierSwitchBreaker<T, R> implements SwitchBreaker<T, R> {

  private final Supplier<R> returnValue;

  public SupplierSwitchBreaker(Supplier<R> returnValue) {
    this.returnValue = returnValue;
  }

  @Override
  public R apply(T input) {
    return returnValue.get();
  }
}
