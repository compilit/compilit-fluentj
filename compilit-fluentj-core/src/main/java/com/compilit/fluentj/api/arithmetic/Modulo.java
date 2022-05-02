package com.compilit.fluentj.api.arithmetic;

import com.compilit.fluentj.api.operations.ConnectingUnaryOperator;

public final class Modulo {
  private Modulo() {
  }

  public static ConnectingUnaryOperator<Integer> moduloItBy(final int divisor) {
    return x -> x % divisor;
  }

  public static ConnectingUnaryOperator<Long> moduloItBy(final long divisor) {
    return x -> x % divisor;
  }

  public static ConnectingUnaryOperator<Float> moduloItBy(final float divisor) {
    return x -> x % divisor;
  }

  public static ConnectingUnaryOperator<Double> moduloItBy(final double divisor) {
    return x -> x % divisor;
  }

  public static ConnectingUnaryOperator<Integer> modulatingItBy(final int divisor) {
    return moduloItBy(divisor);
  }

  public static ConnectingUnaryOperator<Long> modulatingItBy(final long divisor) {
    return moduloItBy(divisor);
  }

  public static ConnectingUnaryOperator<Float> modulatingItBy(float divisor) {
    return moduloItBy(divisor);
  }

  public static ConnectingUnaryOperator<Double> modulatingItBy(double divisor) {
    return moduloItBy(divisor);
  }
}
