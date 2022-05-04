package com.compilit.fluentj.api.arithmetic;

import java.util.function.UnaryOperator;

public final class Subtraction {
  private Subtraction() {
  }

  public static UnaryOperator<Integer> subtracting(final int subtrahend) {
    return x -> x - subtrahend;
  }

  public static UnaryOperator<Long> subtracting(final long subtrahend) {
    return x -> x - subtrahend;
  }

  public static UnaryOperator<Float> subtracting(final float subtrahend) {
    return x -> x - subtrahend;
  }

  public static UnaryOperator<Double> subtracting(final double subtrahend) {
    return x -> x - subtrahend;
  }

  public static UnaryOperator<Integer> subtractItWith(final int subtrahend) {
    return subtracting(subtrahend);
  }

  public static UnaryOperator<Long> subtractItWith(final long subtrahend) {
    return subtracting(subtrahend);
  }

  public static UnaryOperator<Float> subtractItWith(final float subtrahend) {
    return subtracting(subtrahend);
  }

  public static UnaryOperator<Double> subtractItWith(final double subtrahend) {
    return subtracting(subtrahend);
  }

  public static UnaryOperator<Integer> subtractingItWith(final int subtrahend) {
    return subtractItWith(subtrahend);
  }

  public static UnaryOperator<Long> subtractingItWith(final long subtrahend) {
    return subtractItWith(subtrahend);
  }

  public static UnaryOperator<Float> subtractingItWith(final float subtrahend) {
    return subtractItWith(subtrahend);
  }

  public static UnaryOperator<Double> subtractingItWith(final double subtrahend) {
    return subtractItWith(subtrahend);
  }

  public static UnaryOperator<Integer> decrementingIt() {
    return x -> -x;
  }
}
