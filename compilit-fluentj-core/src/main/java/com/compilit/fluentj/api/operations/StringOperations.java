package com.compilit.fluentj.api.operations;

public final class StringOperations {
  private StringOperations() {
  }

  public static ConnectingUnaryOperator<String> appending(final String value) {
    return x -> x += value;
  }

  public static ConnectingUnaryOperator<String> appending(final char value) {
    return x -> x += value;
  }

}
