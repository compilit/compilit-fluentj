package com.compilit.fluentj.api.expressions;

import java.util.function.Predicate;
import java.util.function.Supplier;

class SupplierExpression<T, R> extends AbstractExpression<T, R> implements Expression<T, R> {

  private final Supplier<R> supplier;

  public SupplierExpression(Predicate<T> predicate, Supplier<R> supplier) {
    super(predicate, false);
    this.supplier = supplier;
  }

  public SupplierExpression(Predicate<T> predicate, Supplier<R> supplier, boolean isComplete) {
    super(predicate, isComplete);
    this.supplier = supplier;
  }

  @Override
  public R apply(T input) {
    if (predicate.test(input))
      return supplier.get();
    return next.apply(input);
  }

}
