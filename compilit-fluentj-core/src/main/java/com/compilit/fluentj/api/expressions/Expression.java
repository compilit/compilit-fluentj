package com.compilit.fluentj.api.expressions;

public interface Expression<T, R> {
  R apply(T input);
  boolean isComplete();
  void append(Expression<T, R> next);
}
