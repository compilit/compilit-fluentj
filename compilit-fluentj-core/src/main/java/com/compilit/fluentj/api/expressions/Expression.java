package com.compilit.fluentj.api.expressions;

import java.util.function.Function;

public interface Expression<T, R> extends Function<T, R> {
  boolean isComplete();

  void append(Expression<T, R> next);

}
