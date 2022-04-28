package com.compilit.fluentj.api.valueguard;

class CastExecutorBuilder<T> implements CastExecutor<T> {

  private final T value;
  private final Class<?> castTarget;

  public CastExecutorBuilder(T value, Class<?> castTarget) {
    this.value = value;
    this.castTarget = castTarget;
  }

  @Override
  public T orReturnNull() {
    return ValueGuards.castOrNull(value, castTarget);
  }
}
