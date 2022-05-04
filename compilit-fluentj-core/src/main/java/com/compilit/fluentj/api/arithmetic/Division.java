package com.compilit.fluentj.api.arithmetic;

import java.util.function.UnaryOperator;

public final class Division {
  private Division() {
  }

  public static UnaryOperator<Integer> divideItBy(final int divisor) {
    return x -> x / divisor;
  }

  public static UnaryOperator<Long> divideItBy(final long divisor) {
    return x -> x / divisor;
  }

  public static UnaryOperator<Float> divideItBy(final float divisor) {
    return x -> x / divisor;
  }

  public static UnaryOperator<Double> divideItBy(final double divisor) {
    return x -> x / divisor;
  }

  public static UnaryOperator<Integer> dividingItBy(final int divisor) {
    return divideItBy(divisor);
  }

  public static UnaryOperator<Long> dividingItBy(final long divisor) {
    return divideItBy(divisor);
  }

  public static UnaryOperator<Float> dividingItBy(final float divisor) {
    return divideItBy(divisor);
  }

  public static UnaryOperator<Double> dividingItBy(final double divisor) {
    return divideItBy(divisor);
  }

}
