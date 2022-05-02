package com.compilit.fluentj.core.api;

import com.compilit.fluentj.exceptions.IncompleteExpressionException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import testutil.AbstractTestWithContext;

import static com.compilit.fluentj.api.expressions.ConditionalExpressions.inCaseThat;
import static com.compilit.fluentj.api.expressions.Expressions.is;
import static com.compilit.fluentj.api.expressions.Expressions.isAnyThingElseThenReturn;
import static com.compilit.fluentj.api.operations.ConditionalOperations.then;
import static com.compilit.fluentj.api.operations.ReturningOperations.thenReturn;

class FluentJSwitchExpressionTests extends AbstractTestWithContext {

  @Test
  void nonReturningSwitch_singleMatch_shouldInteract() {
    inCaseThat(1, is(1, then(super::interact)));
    Assertions.assertThat(super.hasBeenInteractedWith()).isTrue();
  }

  @Test
  void nonReturningSwitch_noMatch_shouldNotInteract() {
    inCaseThat(1, is(10, then(super::interact)));
    Assertions.assertThat(super.hasBeenInteractedWith()).isFalse();
  }

  @Test
  void nonReturningSwitch_multipleMatches_shouldInteractMultipleTimes() {
    inCaseThat(1,
            is(1, then(super::interact)),
            is(1, then(super::interact)),
            is(1, then(super::interact)));
    Assertions.assertThat(super.hasBeenInteractedWith(3)).isTrue();
  }

  @Test
  void nonReturningSwitch_singleMatch_shouldInteractOneTime() {
    inCaseThat(1,
            is(1, then(super::interact)),
            is(10, then(super::interact)),
            is(100, then(super::interact)));
    Assertions.assertThat(super.hasBeenInteractedWith(1)).isTrue();
  }

  @Test
  void returningSwitch_noDefault_shouldThrowException() {
    Assertions.assertThatThrownBy(() -> inCaseThat(1, is(1, thenReturn("text"))))
            .isInstanceOf(IncompleteExpressionException.class);
  }

  @Test
  void returningSwitch_true_shouldReturnFirstMatch() {
    var result = inCaseThat(1,
            is(1, thenReturn(expected)),
            is(1, thenReturn(notExpected)),
            is(1, thenReturn(notExpected)),
            isAnyThingElseThenReturn(notExpected));
    Assertions.assertThat(result).isEqualTo(expected);
  }

  @Test
  void returningSwitch_true_shouldReturnMatch() {
    var result = inCaseThat(1,
            is(10, thenReturn(notExpected)),
            is(10, thenReturn(notExpected)),
            is(1, thenReturn(expected)),
            isAnyThingElseThenReturn(notExpected));
    Assertions.assertThat(result).isEqualTo(expected);
  }

}
