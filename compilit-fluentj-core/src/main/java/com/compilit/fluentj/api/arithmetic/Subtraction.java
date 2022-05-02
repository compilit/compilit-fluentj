package com.compilit.fluentj.api.arithmetic;

import com.compilit.fluentj.api.operations.ConnectingUnaryOperator;

public final class Subtraction {
  private Subtraction() {
  }

  public static ConnectingUnaryOperator<Integer> subtracting(final int subtrahend) {
    return x -> x - subtrahend;
  }

  public static ConnectingUnaryOperator<Long> subtracting(final long subtrahend) {
    return x -> x - subtrahend;
  }

  public static ConnectingUnaryOperator<Float> subtracting(final float subtrahend) {
    return x -> x - subtrahend;
  }

  public static ConnectingUnaryOperator<Double> subtracting(final double subtrahend) {
    return x -> x - subtrahend;
  }

  public static ConnectingUnaryOperator<Integer> subtractItWith(final int subtrahend) {
    return subtracting(subtrahend);
  }

  public static ConnectingUnaryOperator<Long> subtractItWith(final long subtrahend) {
    return subtracting(subtrahend);
  }

  public static ConnectingUnaryOperator<Float> subtractItWith(final float subtrahend) {
    return subtracting(subtrahend);
  }

  public static ConnectingUnaryOperator<Double> subtractItWith(final double subtrahend) {
    return subtracting(subtrahend);
  }

  public static ConnectingUnaryOperator<Integer> subtractingItWith(final int subtrahend) {
    return subtractItWith(subtrahend);
  }

  public static ConnectingUnaryOperator<Long> subtractingItWith(final long subtrahend) {
    return subtractItWith(subtrahend);
  }

  public static ConnectingUnaryOperator<Float> subtractingItWith(final float subtrahend) {
    return subtractItWith(subtrahend);
  }

  public static ConnectingUnaryOperator<Double> subtractingItWith(final double subtrahend) {
    return subtractItWith(subtrahend);
  }
}
