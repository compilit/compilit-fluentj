package com.compilit.fluentj.core.api.expressions;

import com.compilit.fluentj.api.expressions.Expressions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import testutil.AbstractTestWithContext;

import static com.compilit.fluentj.api.expressions.ConditionalExpressions.inCaseThat;
import static com.compilit.fluentj.api.expressions.Expressions.is;
import static com.compilit.fluentj.api.expressions.Expressions.otherwise;
import static com.compilit.fluentj.api.expressions.Expressions.otherwiseReturn;
import static com.compilit.fluentj.api.operations.ConnectingOperations.then;
import static com.compilit.fluentj.api.operations.ReturningOperations.thenReturn;
import static org.assertj.core.api.Fail.fail;

class IfElseExpressionTests extends AbstractTestWithContext {

  @Test
  void nonReturningIfStatement_true_shouldInteract() {
    inCaseThat(1, is(1, then(super::interact)));
    Assertions.assertThat(hasBeenInteractedWith()).isTrue();
  }

  @Test
  void nonReturningIfStatement_false_shouldNotInteract() {
    inCaseThat(1, is(10, then(super::interact)));
    Assertions.assertThat(hasBeenInteractedWith()).isFalse();
  }

  @Test
  void defaultingReturningIfElseStatement_true_shouldInteract() {
    inCaseThat(1, is(1, then(super::interact)), otherwise(() -> fail(notExpected)));
    Assertions.assertThat(hasBeenInteractedWith()).isTrue();
  }

  @Test
  void defaultingReturningIfElseStatement_false_shouldInteract() {
    inCaseThat(1, is(10, then(() -> fail(notExpected))), otherwise(super::interact));
    Assertions.assertThat(hasBeenInteractedWith()).isTrue();
  }

  @Test
  void returningIfElseStatement_true_shouldReturnExpected() {
    var result = inCaseThat(1, is(1, thenReturn(expected)), otherwiseReturn(notExpected));
    Assertions.assertThat(result).isEqualTo(expected);
  }

  @Test
  void returningIfElseStatement_false_shouldReturnExpected() {
    var result = inCaseThat(1,
            is(10, thenReturn(notExpected)),
            otherwiseReturn(expected));
    Assertions.assertThat(result).isEqualTo(expected);
  }

//  @Test
//  void nonReturningBooleanIfStatement_true_shouldInteract() {
//    var itIsTrue = true;
//    inCaseThat(itIsTrue, then(super::interact));
//    Assertions.assertThat(hasBeenInteractedWith()).isTrue();
//  }
//
//  @Test
//  void nonReturningBooleanIfStatement_false_shouldNotInteract() {
//    var itIsTrue = false;
//    inCaseThat(itIsTrue, then(super::interact));
//    Assertions.assertThat(hasBeenInteractedWith()).isFalse();
//  }
//
//  @Test
//  void returningBooleanIfStatement_true_shouldReturnSupplierValue() {
//    var itIsTrue = true;
//    var actual = inCaseThat(itIsTrue, thenReturn(expected), otherwiseReturn(notExpected));
//    Assertions.assertThat(actual).isEqualTo(expected);
//  }
//
//  @Test
//  void returningBooleanIfStatement_false_shouldReturnDefaultSupplierValue() {
//    var itIsTrue = false;
//    var actual = inCaseThat(itIsTrue, thenReturn(notExpected), otherwiseReturn(expected));
//    Assertions.assertThat(actual).isEqualTo(expected);
//  }

}
