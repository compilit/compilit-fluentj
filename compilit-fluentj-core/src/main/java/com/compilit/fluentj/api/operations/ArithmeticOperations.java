package com.compilit.fluentj.api.operations;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public final class ArithmeticOperations {

  private ArithmeticOperations() {
  }

  public static UnaryOperator<Integer> incrementingIt() {
    return x -> {
      var num = x;
      num += x;
      return num;
    };
  }

  public static BiFunction<Integer, Integer, Integer> addingThePreviousValueToIt() {
    return (x, y) -> {
      var num = x;
      num = x + y;
      return num;
    };
  }

}
