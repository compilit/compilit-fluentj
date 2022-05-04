package com.compilit.fluentj.api.expressions;

public interface Expression<T, R> {
  boolean isComplete();

  void append(Expression<T, R> next);

  R apply(T input, boolean hasMatchedPredicate);

}
