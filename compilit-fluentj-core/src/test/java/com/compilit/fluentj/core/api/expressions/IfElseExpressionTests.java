package com.compilit.fluentj.core.api.expressions;

import com.compilit.testtools.AbstractTestContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.compilit.fluentj.api.expressions.ConditionalExpressions.inCaseThat;
import static com.compilit.fluentj.api.expressions.ConditionalExpressions.inCaseThatIt;
import static com.compilit.fluentj.api.expressions.Expressions.is;
import static com.compilit.fluentj.api.expressions.Expressions.otherwise;
import static com.compilit.fluentj.api.expressions.Expressions.otherwiseReturn;
import static com.compilit.fluentj.api.operations.ConnectingOperations.then;
import static com.compilit.fluentj.api.operations.ReturningOperations.thenReturn;
import static com.compilit.testtools.TestValues.DEFAULT_STRING_VALUE;
import static com.compilit.testtools.TestValues.STRING_VALUE;
import static org.assertj.core.api.Fail.fail;

class IfElseExpressionTests extends AbstractTestContext {

  @Test
  void nonReturningIfStatement_true_shouldInteract() {
    inCaseThat(1, is(1, then(super::interact)));
    assertInteraction();
  }

  @Test
  void nonReturningIfStatement_false_shouldNotInteract() {
    inCaseThat(1, is(10, then(super::interact)));
    assertNoInteraction();
  }

  @Test
  void defaultingReturningIfElseStatement_true_shouldInteract() {
    inCaseThat(1, is(1, then(super::interact)), otherwise(() -> fail(DEFAULT_STRING_VALUE)));
    assertInteraction();
  }

  @Test
  void defaultingReturningIfElseStatement_false_shouldInteract() {
    inCaseThat(1, is(10, then(() -> fail(DEFAULT_STRING_VALUE))), otherwise(super::interact));
    assertInteraction();
  }

  @Test
  void returningIfElseStatement_true_shouldReturnExpected() {
    var result = inCaseThat(1, is(1, thenReturn(STRING_VALUE)), otherwiseReturn(DEFAULT_STRING_VALUE));
    Assertions.assertThat(result).isEqualTo(STRING_VALUE);
  }

  @Test
  void returningIfElseStatement_false_shouldReturnExpected() {
    var result = inCaseThat(1,
            is(10, thenReturn(DEFAULT_STRING_VALUE)),
            otherwiseReturn(STRING_VALUE));
    Assertions.assertThat(result).isEqualTo(STRING_VALUE);
  }

  @Test
  void functionalIfStatement_shouldReturnExpression() {
    var expression = inCaseThatIt(is(true, then(super::interact)));
    expression.apply(true);
    assertInteraction();
  }

}
