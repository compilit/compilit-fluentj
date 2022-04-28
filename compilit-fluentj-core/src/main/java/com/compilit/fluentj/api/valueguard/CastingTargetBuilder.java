package com.compilit.fluentj.api.valueguard;

import java.util.function.Consumer;
import java.util.function.Function;

public final class CastingTargetBuilder<T> {

  private CastingTargetBuilder() {}

  public static <T, R> Function<T, R> to(Class<R> clazz) {
     return clazz::cast;
  }

}
