package com.compilit.fluentj.core.valueguard;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.compilit.fluentj.api.valueguard.ValueGuards.asIntegerOrOtherwise;
import static com.compilit.fluentj.api.valueguard.ValueGuards.asIntegerOrNull;
import static com.compilit.fluentj.api.valueguard.ValueGuards.castOrNull;
import static com.compilit.fluentj.api.valueguard.ValueGuards.orDefault;
import static com.compilit.fluentj.api.valueguard.ValueGuards.orNull;

class ValueGuardsTests extends AbstractValueTests {

  @Test
  void orNull_noExceptionThrown_shouldReturnValue() {
    Assertions.assertThat(orNull(() -> stringValue)).isEqualTo(stringValue);
  }

  @Test
  void orNull_exceptionThrown_shouldReturnNull() {
    Assertions.assertThat(orNull(() -> nullValue.getBytes())).isNull();
  }

  @Test
  void orDefault_noExceptionThrown_shouldReturnValue() {
    Assertions.assertThat(orDefault(() -> stringValue, defaultValue)).isEqualTo(stringValue);
  }

  @Test
  void orDefault_exceptionThrown_shouldReturnDefaultValue() {
    Assertions.assertThat(orDefault(() -> nullValue.getBytes(), defaultValue)).isEqualTo(defaultValue);
  }

  @Test
  void asIntOrNull_noExceptionThrown_shouldReturnValue() {
    Assertions.assertThat(asIntegerOrNull(() -> intStringValue)).isEqualTo(intValue);
  }

  @Test
  void asIntOrNull_exceptionThrown_shouldReturnNull() {
    Assertions.assertThat(asIntegerOrNull(() -> nullValue)).isNull();
  }

  @Test
  void asIntOrDefault_noExceptionThrown_shouldReturnValue_shouldReturnValue() {
    Assertions.assertThat(asIntegerOrOtherwise(() -> intStringValue, defaultIntValue)).isEqualTo(intValue);
  }

  @Test
  void asIntOrDefault_exceptionThrown_shouldReturnDefaultValue() {
    Assertions.assertThat(asIntegerOrOtherwise(() -> nullValue, defaultIntValue)).isEqualTo(defaultIntValue);
  }

  @Test
  void castOrNull_noExceptionThrown_shouldReturnValue() {
    final Object test = stringValue;
    Assertions.assertThat(castOrNull(test, String.class)).isEqualTo(stringValue);
  }

  @Test
  void castOrNull_exceptionThrown_shouldReturnNull() {
    Assertions.assertThat(castOrNull(stringValue, Integer.class)).isEqualTo(null);
  }

}
