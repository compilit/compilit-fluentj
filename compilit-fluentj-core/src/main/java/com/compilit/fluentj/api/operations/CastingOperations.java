package com.compilit.fluentj.api.operations;

import java.util.function.Function;

public final class CastingOperations<T> {

  private CastingOperations() {}

  public static <T, R> Function<T, R> to(Class<R> clazz) {
     return clazz::cast;
  }

}
