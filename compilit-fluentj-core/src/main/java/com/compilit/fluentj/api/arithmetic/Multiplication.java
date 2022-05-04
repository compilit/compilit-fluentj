package com.compilit.fluentj.api.arithmetic;

import java.util.function.UnaryOperator;

public final class Multiplication {
  private Multiplication() {
  }

  public static UnaryOperator<Integer> multiplyItBy(final int multiplier) {
    return x -> x * multiplier;
  }

  public static UnaryOperator<Long> multiplyItBy(final long multiplier) {
    return x -> x * multiplier;
  }

  public static UnaryOperator<Float> multiplyItBy(final float multiplier) {
    return x -> x * multiplier;
  }

  public static UnaryOperator<Double> multiplyItBy(final double multiplier) {
    return x -> x * multiplier;
  }

  public static UnaryOperator<Integer> multiplyingItBy(final int multiplier) {
    return multiplyItBy(multiplier);
  }

  public static UnaryOperator<Long> multiplyingItBy(final long multiplier) {
    return multiplyItBy(multiplier);
  }

  public static UnaryOperator<Float> multiplyingItBy(final float multiplier) {
    return multiplyItBy(multiplier);
  }

  public static UnaryOperator<Double> multiplyingItBy(final double multiplier) {
    return multiplyItBy(multiplier);
  }
}
