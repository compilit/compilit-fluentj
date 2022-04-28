package com.compilit.fluentj.core.valueguard;

import com.compilit.fluentj.api.valueguard.CastExecutor;
import com.compilit.fluentj.api.valueguard.CastingTarget;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.compilit.fluentj.api.operations.DefaultReturningOperations.otherwiseReturn;
import static com.compilit.fluentj.api.valueguard.CastingTargetBuilder.to;
import static com.compilit.fluentj.api.valueguard.ValueGuards.cast;

class CastingBuilderTests extends AbstractValueTests {

  @Test
  void to_shouldReturnCastExecutor() {
    Assertions.assertThat(cast(stringValue, to(String.class))).isInstanceOf(CastExecutor.class);
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
