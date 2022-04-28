package com.compilit.fluentj.api.arithmetic;

import java.util.function.UnaryOperator;

public final class Modulo {

  private Modulo() {}

  public static UnaryOperator<Integer> moduloItBy(final int divisor) {
    return x -> x % divisor;
  }
  public static UnaryOperator<Long> moduloItBy(final long divisor) {
    return x -> x % divisor;
  }
  public static UnaryOperator<Float> moduloItBy(final float divisor) {
    return x -> x % divisor;
  }
  public static UnaryOperator<Double> moduloItBy(final double divisor) {
    return x -> x % divisor;
  }

  public static UnaryOperator<Integer> modulatingItBy(final int divisor) {
    return moduloItBy(divisor);
  }

  public static UnaryOperator<Long> modulatingItBy(final long divisor) {
    return moduloItBy(divisor);
  }

  public static UnaryOperator<Float> modulatingItBy(float divisor) {
    return moduloItBy(divisor);
  }

  public static UnaryOperator<Double> modulatingItBy(double divisor) {
    return moduloItBy(divisor);
  }
}
