package com.compilit.fluentj.core.api.operations;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import testutil.AbstractValueTests;

import java.util.List;

import static com.compilit.fluentj.api.loops.Loops.takeEachEntryIn;
import static com.compilit.fluentj.api.operations.CastingOperations.cast;
import static com.compilit.fluentj.api.operations.CastingOperations.castItTo;
import static com.compilit.fluentj.api.operations.CastingOperations.to;
import static com.compilit.fluentj.api.operations.ConnectingOperations.and;
import static com.compilit.fluentj.api.operations.DefaultReturningOperations.otherwiseReturn;
import static com.compilit.fluentj.api.operations.ExceptionOperations.inCaseOfAnException;
import static com.compilit.fluentj.api.operations.LoggerOperations.printIt;

class CastingOperationsTests extends AbstractValueTests {

  @Test
  void to_noException_shouldReturnStringValue() {
    Assertions.assertThat(cast(stringValue, to(String.class), otherwiseReturn(defaultValue), and(inCaseOfAnException(printIt())))).isEqualTo(stringValue);
  }

  @Test
  void orReturnNull_noExceptionThrown_shouldReturnValue() {
    Assertions.assertThat(cast(stringValue, to(String.class), otherwiseReturn("test"))).isEqualTo(stringValue);
  }

  @Test
  void orReturnNull_exceptionThrown_shouldReturnDefaultValue() {
    Assertions.assertThat(cast(intValue, to(String.class), otherwiseReturn(defaultValue))).isEqualTo(defaultValue);
  }

}
