package com.compilit.fluentj.api.operations;

import java.util.function.UnaryOperator;

public final class StringOperations {
  private StringOperations() {
  }

  public static UnaryOperator<String> appending(final String value) {
    return x -> x += value;
  }

  public static UnaryOperator<String> appending(final char value) {
    return x -> x += value;
  }

}
