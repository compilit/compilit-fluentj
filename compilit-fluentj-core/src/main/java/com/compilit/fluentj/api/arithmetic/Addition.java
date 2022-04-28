package com.compilit.fluentj.api.arithmetic;

import java.util.function.UnaryOperator;

public final class Addition {
  private Addition() {}

  public static UnaryOperator<Integer> add(final int addend) {
    return x -> x + addend;
  }

  public static UnaryOperator<Long> add(final long addend) {
    return x -> x + addend;
  }

  public static UnaryOperator<Float> add(final float addend) {
    return x -> x + addend;
  }

  public static UnaryOperator<Double> add(final double addend) {
    return x -> x + addend;
  }

  public static UnaryOperator<Integer> adding(final int addend) {
    return add(addend);
  }

  public static UnaryOperator<Long> adding(final long addend) {
    return add(addend);
  }

  public static UnaryOperator<Float> adding(final float addend) {
    return add(addend);
  }

  public static UnaryOperator<Double> adding(final double addend) {
    return add(addend);
  }
}
