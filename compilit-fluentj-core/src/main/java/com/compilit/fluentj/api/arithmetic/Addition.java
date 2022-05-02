package com.compilit.fluentj.api.arithmetic;

import com.compilit.fluentj.api.operations.ConnectingUnaryOperator;

import java.util.function.BiFunction;

public final class Addition {
  private Addition() {
  }

  public static ConnectingUnaryOperator<Integer> add(final int addend) {
    return x -> x + addend;
  }

  public static ConnectingUnaryOperator<Long> add(final long addend) {
    return x -> x + addend;
  }

  public static ConnectingUnaryOperator<Float> add(final float addend) {
    return x -> x + addend;
  }

  public static ConnectingUnaryOperator<Double> add(final double addend) {
    return x -> x + addend;
  }

  public static ConnectingUnaryOperator<Integer> adding(final int addend) {
    return add(addend);
  }

  public static ConnectingUnaryOperator<Long> adding(final long addend) {
    return add(addend);
  }

  public static ConnectingUnaryOperator<Float> adding(final float addend) {
    return add(addend);
  }

  public static ConnectingUnaryOperator<Double> adding(final double addend) {
    return add(addend);
  }

  public static BiFunction<Integer, Integer, Integer> addingThePreviousValueToIt() {
    return Integer::sum;
  }

  public static ConnectingUnaryOperator<Integer> incrementingIt() {
    return x -> {
      if (x == 0) {
        return 1;
      }
      return x + x;
    };
  }
}
