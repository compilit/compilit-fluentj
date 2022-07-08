package com.compilit.fluentj.core.api.operations;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.compilit.fluentj.api.operations.ReturningOperations.inCaseOfAnExceptionReturnNull;
import static com.compilit.testtools.TestValues.NULL_STRING;
import static com.compilit.testtools.TestValues.STRING_VALUE;


public final class ReturningOperationsTests {

  @Test
  void orNull_noExceptionThrown_shouldReturnValue() {
    Assertions.assertThat(inCaseOfAnExceptionReturnNull().apply(() -> STRING_VALUE)).isEqualTo(STRING_VALUE);
  }

  @Test
  void orNull_exceptionThrown_shouldReturnNull() {
    Assertions.assertThat(inCaseOfAnExceptionReturnNull().apply(() -> NULL_STRING.getBytes())).isNull();
  }
}
