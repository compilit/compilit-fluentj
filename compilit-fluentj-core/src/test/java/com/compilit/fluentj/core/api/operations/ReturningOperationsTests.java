package com.compilit.fluentj.core.api.operations;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import testutil.AbstractValueTests;

import static com.compilit.fluentj.api.operations.ReturningOperations.inCaseOfAnExceptionReturnNull;


public final class ReturningOperationsTests extends AbstractValueTests {

  @Test
  void orNull_noExceptionThrown_shouldReturnValue() {
    Assertions.assertThat(inCaseOfAnExceptionReturnNull().apply(() -> stringValue)).isEqualTo(stringValue);
  }

  @Test
  void orNull_exceptionThrown_shouldReturnNull() {
    Assertions.assertThat(inCaseOfAnExceptionReturnNull().apply(() -> nullValue.getBytes())).isNull();
  }
}
