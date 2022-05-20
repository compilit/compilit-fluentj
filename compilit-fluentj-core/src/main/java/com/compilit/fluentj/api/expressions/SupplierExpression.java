package com.compilit.fluentj.api.expressions;

import java.util.function.Predicate;
import java.util.function.Supplier;

class SupplierExpression<T, R> extends AbstractExpression<T, R> implements Expression<T, R> {

  private final Supplier<R> supplier;

  public SupplierExpression(Predicate<T> predicate, Supplier<R> supplier, boolean isComplete, boolean isDefault) {
    super(predicate, isComplete, isDefault);
    this.supplier = supplier;
  }

  @Override
  public R apply(T input, boolean hasMatchedPredicate) {
    if (isDefaultNonComplying(input, hasMatchedPredicate)) {
      return supplier.get();
    } else if (predicate.test(input)) {
      return supplier.get();
    }
    return next.apply(input, hasMatchedPredicate);
  }

}
