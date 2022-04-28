package com.compilit.fluentj.exceptions;

public final class IncompleteStatementException extends RuntimeException {
  public static final String MESSAGE = "The statement is not complete, check if all paths return a value";

  public IncompleteStatementException() {
    super(MESSAGE);
  }
}
