package com.compilit.fluentj.api.valueguard;

public interface CastingTarget<T> {
  CastExecutor<T> to(Class<?> clazz);
}
