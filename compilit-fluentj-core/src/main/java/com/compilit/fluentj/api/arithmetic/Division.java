package com.compilit.fluentj.api.arithmetic;

import com.compilit.fluentj.api.operations.ConnectingUnaryOperator;

public final class Division {
  private Division() {
  }

  public static ConnectingUnaryOperator<Integer> divideItBy(final int divisor) {
    return x -> x / divisor;
  }

  public static ConnectingUnaryOperator<Long> divideItBy(final long divisor) {
    return x -> x / divisor;
  }

  public static ConnectingUnaryOperator<Float> divideItBy(final float divisor) {
    return x -> x / divisor;
  }

  public static ConnectingUnaryOperator<Double> divideItBy(final double divisor) {
    return x -> x / divisor;
  }

  public static ConnectingUnaryOperator<Integer> dividingItBy(final int divisor) {
    return divideItBy(divisor);
  }

  public static ConnectingUnaryOperator<Long> dividingItBy(final long divisor) {
    return divideItBy(divisor);
  }

  public static ConnectingUnaryOperator<Float> dividingItBy(final float divisor) {
    return divideItBy(divisor);
  }

  public static ConnectingUnaryOperator<Double> dividingItBy(final double divisor) {
    return divideItBy(divisor);
  }

}
