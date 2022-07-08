package com.compilit.fluentj.core.api.expressions;

import com.compilit.fluentj.exceptions.IncompleteExpressionException;
import com.compilit.testtools.AbstractTestContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.compilit.fluentj.api.expressions.ConditionalExpressions.inCaseThat;
import static com.compilit.fluentj.api.expressions.Expressions.*;
import static com.compilit.fluentj.api.operations.ConnectingOperations.then;
import static com.compilit.fluentj.api.operations.ReturningOperations.thenReturn;
import static com.compilit.fluentj.api.predicates.Predicates.itIs;
import static com.compilit.fluentj.api.predicates.Predicates.itIsAnInteger;
import static com.compilit.testtools.TestValues.DEFAULT_STRING_VALUE;
import static com.compilit.testtools.TestValues.STRING_VALUE;

class SwitchExpressionTests extends AbstractTestContext {

  @Test
  void nonReturningSwitch_singleMatch_shouldInteract() {
    inCaseThat(1, is(1, then(super::interact)));
    assertInteraction();
  }

  @Test
  void nonReturningSwitch_noMatch_shouldNotInteract() {
    inCaseThat(1, is(10, then(super::interact)));
    assertNoInteraction();
  }

  @Test
  void nonReturningSwitch_multipleMatches_shouldInteractMultipleTimes() {
    inCaseThat(1,
            is(1, then(super::interact)),
            is(1, then(super::interact)),
            is(1, then(super::interact)));
    assertInteraction(3);
  }

  @Test
  void nonReturningSwitch_singleMatch_shouldInteractOneTime() {
    inCaseThat(1,
            is(1, then(super::interact)),
            is(10, then(super::interact)),
            is(100, then(super::interact)));
    assertInteraction(1);
  }

  @Test
  void returningSwitch_noDefault_shouldThrowException() {
    Assertions.assertThatThrownBy(() -> inCaseThat(1, is(1, thenReturn("text"))))
            .isInstanceOf(IncompleteExpressionException.class);
  }

  @Test
  void returningSwitch_multipleMatches_shouldReturnFirstMatch() {
    var result = inCaseThat(1,
            is(1, thenReturn(STRING_VALUE)),
            is(1, thenReturn(DEFAULT_STRING_VALUE)),
            is(1, thenReturn(DEFAULT_STRING_VALUE)),
            otherwiseReturn(DEFAULT_STRING_VALUE));
    Assertions.assertThat(result).isEqualTo(STRING_VALUE);
  }

  @Test
  void returningSwitch_true_shouldReturnMatch() {
    var result = inCaseThat(1,
            is(100, thenReturn(DEFAULT_STRING_VALUE)),
            is(10, thenReturn(DEFAULT_STRING_VALUE)),
            is(1, thenReturn(STRING_VALUE)),
            otherwiseReturn(DEFAULT_STRING_VALUE));
    Assertions.assertThat(result).isEqualTo(STRING_VALUE);
  }

  @Test
  void returningPredicateSwitch_true_shouldReturnMatch() {
    var result = inCaseThat(10,
            matchesThat(itIs(10).and(itIsAnInteger()), thenReturn(STRING_VALUE)),
            is(10, thenReturn(DEFAULT_STRING_VALUE)),
            is(1, thenReturn(DEFAULT_STRING_VALUE)),
            otherwiseReturn(DEFAULT_STRING_VALUE));
    Assertions.assertThat(result).isEqualTo(STRING_VALUE);
  }

}
