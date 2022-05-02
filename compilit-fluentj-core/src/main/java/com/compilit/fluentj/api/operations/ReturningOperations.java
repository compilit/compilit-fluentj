package com.compilit.fluentj.api.operations;

import com.compilit.fluentj.api.loops.Loop;
import com.compilit.results.Result;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.compilit.fluentj.api.operations.ExceptionOperations.inCaseOfAnExceptionReturnDefault;

public final class ReturningOperations {
  private ReturningOperations() {
  }

  public static <T> Supplier<T> thenReturn(T value) {
    return () -> value;
  }

  public static <T> ContinuingFunction<Loop<T>, Result<T>> thenReturnTheResult() {
    return it -> Result.resultOf(it::resolveAll);
  }

  public static <T> ContinuingFunction<T, Result<T>> andReturnResult() {
    return it -> Result.resultOf(() -> it);
  }

  public static Supplier<Boolean> thenItIsTrue() {
    return () -> true;
  }

  public static Supplier<Boolean> thenItIsFalse() {
    return () -> false;
  }

  public static <T> ContinuingFunction<Supplier<T>, T> inCaseOfAnExceptionReturnNull() {
    return inCaseOfAnExceptionReturn(null);
  }

  public static <T> ContinuingFunction<Supplier<T>, T> inCaseOfAnExceptionReturn(T defaultValue) {
    return it -> inCaseOfAnExceptionReturnDefault(it, defaultValue);
  }


}
