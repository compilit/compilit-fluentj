package com.compilit.fluentj.exceptions;

public final class IncompleteExpressionException extends RuntimeException {
  public static final String MESSAGE = "The expression is not complete, check if all paths return a value";

  public IncompleteExpressionException() {
    super(MESSAGE);
  }
}
