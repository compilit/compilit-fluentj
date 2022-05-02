package com.compilit.fluentj.api.arithmetic;

import com.compilit.fluentj.api.operations.ConnectingUnaryOperator;

public final class Multiplication {
  private Multiplication() {
  }

  public static ConnectingUnaryOperator<Integer> multiplyItBy(final int multiplier) {
    return x -> x * multiplier;
  }

  public static ConnectingUnaryOperator<Long> multiplyItBy(final long multiplier) {
    return x -> x * multiplier;
  }

  public static ConnectingUnaryOperator<Float> multiplyItBy(final float multiplier) {
    return x -> x * multiplier;
  }

  public static ConnectingUnaryOperator<Double> multiplyItBy(final double multiplier) {
    return x -> x * multiplier;
  }

  public static ConnectingUnaryOperator<Integer> multiplyingItBy(final int multiplier) {
    return multiplyItBy(multiplier);
  }

  public static ConnectingUnaryOperator<Long> multiplyingItBy(final long multiplier) {
    return multiplyItBy(multiplier);
  }

  public static ConnectingUnaryOperator<Float> multiplyingItBy(final float multiplier) {
    return multiplyItBy(multiplier);
  }

  public static ConnectingUnaryOperator<Double> multiplyingItBy(final double multiplier) {
    return multiplyItBy(multiplier);
  }
}
