package com.compilit.fluentj.api.expressions;

import com.compilit.fluentj.exceptions.IncompleteExpressionException;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public final class ConditionalExpressions {

  private ConditionalExpressions() {
  }

  /**
   * A dynamic switch-expression. It takes in a set of predicate/operation combinations in the form of an "AppendingStatement".
   * It should be noted that a FluentJ switch expression takes the English language quite literally.
   * This function is really flexible and as a result, it will not tell you if you've forgotten to state a default returning action at compile time.
   * It will, however, throw an "IncompleteStatementException" at runtime if the statement is incomplete to still catch bugs like this as early as possible.
   * To be clear: an incomplete statement would be something like this, which would cause a compile-time error
   *
   * @param input                the value that goes into the switch-expression.
   * @param expression           the initial expression, take a look at the "Expressions" to get an idea of the possibilities.
   * @param expressionExtensions the extra expression until it is complete, take a look at the "Expressions.class" to get an idea of the possibilities.
   * @param <T>                  the type of the input of the switch-expression.
   * @param <R>                  the return type of the switch expression.
   * @return the result of the expression.
   */
  @SafeVarargs
  public static <T, R> R inCaseThat(final T input, final Expression<T, R> expression, final Expression<T, R>... expressionExtensions) {
    if (expressionExtensions != null && expressionExtensions.length > 0) {
      for (var statementExtension : expressionExtensions) {
        expression.append(statementExtension);
      }
    }
    if (!expression.isComplete())
      throw new IncompleteExpressionException();
    return expression.apply(input, false);
  }

//  /**
//   * Simple if statement. Takes in a boolean value and an action in the form of a Runnable that needs to be taken in case the boolean resolves to true.
//   *
//   * @param input                the value that goes into the switch-expression.
//   * @param runnable             the process that needs to be started in case that the input resolves to true.
//   */
//  public static void inCaseThat(final boolean input, final Runnable runnable) {
//    if (input)
//      runnable.run();
//  }
//
//  /**
//   * Simple if statement. Takes in a boolean value and an action in the form of a Runnable that needs to be taken in case the boolean resolves to true.
//   *
//   * @param input                the value that goes into the switch-expression.
//   * @param supplier             the Supplier with the value you wish to return on true.
//   * @param defaultExpression    the default value Expression you wish to return on false.
//   */
//  public static <T, R> R inCaseThat(final boolean input, final Supplier<R> supplier, final Expression<T, R> defaultExpression) {
//    if (input)
//      return supplier.get();
//    return defaultExpression.apply(null, true);
//  }

}
