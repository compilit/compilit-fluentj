package com.compilit.fluentj.core.api.operations;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.compilit.fluentj.api.operations.CastingOperations.cast;
import static com.compilit.fluentj.api.operations.CastingOperations.to;
import static com.compilit.fluentj.api.operations.ConnectingOperations.and;
import static com.compilit.fluentj.api.operations.DefaultReturningOperations.otherwiseReturn;
import static com.compilit.fluentj.api.operations.ExceptionOperations.inCaseOfAnException;
import static com.compilit.fluentj.api.operations.LoggerOperations.printIt;
import static com.compilit.testtools.TestValues.*;

class CastingOperationsTests {

  @Test
  void to_noException_shouldReturnStringValue() {
    Assertions.assertThat(cast(STRING_VALUE, to(String.class), otherwiseReturn(DEFAULT_STRING_VALUE), and(inCaseOfAnException(printIt())))).isEqualTo(STRING_VALUE);
  }

  @Test
  void orReturnNull_noExceptionThrown_shouldReturnValue() {
    Assertions.assertThat(cast(STRING_VALUE, to(String.class), otherwiseReturn(DEFAULT_STRING_VALUE))).isEqualTo(STRING_VALUE);
  }

  @Test
  void orReturnNull_exceptionThrown_shouldReturnDefaultValue() {
    Assertions.assertThat(cast(NULL_STRING, to(String.class), otherwiseReturn(DEFAULT_STRING_VALUE))).isEqualTo(DEFAULT_STRING_VALUE);
  }

}
