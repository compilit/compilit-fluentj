package com.compilit.fluentj.api.expressions;

import com.compilit.fluentj.exceptions.IncompleteExpressionException;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class ConditionalExpressions {

  private ConditionalExpressions() {
  }

  /**
   * A non-returning if-expression.
   *
   * @param input     the value that goes into the if-expression.
   * @param predicate the predicate to test against the input value.
   * @param runnable  the operation that needs to be run if the predicate returns true.
   * @param <T>       the type of the input.
   */
  public static <T> void inCaseThat(final T input, final Predicate<T> predicate, final Runnable runnable) {
    if (predicate.test(input))
      runnable.run();
  }

  /**
   * A non-returning if-expression with a default.
   *
   * @param input           the value that goes into the if-expression.
   * @param predicate       the predicate to test against the input value.
   * @param runnable        the operation that needs to be run if the predicate returns true.
   * @param defaultRunnable the operation that needs to be run if the predicate returns false.
   * @param <T>             the type of the input.
   */
  public static <T> T inCaseThat(final T input, final Predicate<T> predicate, final Runnable runnable, final Runnable defaultRunnable) {
    if (predicate.test(input)) {
      runnable.run();
      return input;
    }
    defaultRunnable.run();
    return input;
  }

  /**
   * A non-returning if-expression.
   *
   * @param input     the value that goes into the if-expression.
   * @param predicate the predicate to test against the input value. Takes the input as an argument.
   * @param consumer  the operation that needs to be run if the predicate returns true. Takes the input as an argument.
   * @param <T>       the type of the input.
   */
  public static <T> void inCaseThat(final T input, final Predicate<T> predicate, final Consumer<T> consumer) {
    if (predicate.test(input))
      consumer.accept(input);
  }

  /**
   * A non-returning if-expression with a default.
   *
   * @param input           the value that goes into the if-expression.
   * @param predicate       the predicate to test against the input value.
   * @param consumer        the operation that needs to be run if the predicate returns true. Takes the input as an argument.
   * @param defaultConsumer the operation that needs to be run if the predicate returns false. Takes the input as an argument.
   * @param <T>             the type of the input.
   */
  public static <T> void inCaseThat(final T input, final Predicate<T> predicate, final Consumer<T> consumer, final Consumer<T> defaultConsumer) {
    if (predicate.test(input))
      consumer.accept(input);
    else
      defaultConsumer.accept(input);
  }

  /**
   * A returning if-expression. Since you return something, an alternative (default) needs to be provided.
   *
   * @param input           the value that goes into the if-expression.
   * @param predicate       the predicate to test against the input value. Takes the input as an argument.
   * @param supplier        the operation that needs to be run if the predicate returns true. Takes the input as an argument.
   * @param defaultSupplier the operation that needs to be run if the predicate returns true. Takes the input as an argument.
   * @param <T>             the type of the input.
   * @return the result of the expression.
   */
  public static <T, R> R inCaseThat(final T input, final Predicate<T> predicate, final Supplier<R> supplier, final Supplier<R> defaultSupplier) {
    if (predicate.test(input)) {
      return supplier.get();
    }
    return defaultSupplier.get();
  }

  /**
   * A returning if-expression. The function arguments are like mappers for you input. Since you return something, an alternative (default) needs to be provided.
   *
   * @param input           the value that goes into the if-expression.
   * @param predicate       the predicate to test against the input value. Takes the input as an argument.
   * @param function        the operation that needs to be run if the predicate returns true. Takes the input as an argument.
   * @param defaultFunction the operation that needs to be run if the predicate returns true. Takes the input as an argument.
   * @param <T>             the type of the input.
   * @return the result of the expression.
   */
  public static <T, R> R inCaseThat(final T input, final Predicate<T> predicate, final Function<T, R> function, final Function<T, R> defaultFunction) {
    if (predicate.test(input))
      return function.apply(input);
    else
      return defaultFunction.apply(input);
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
    return expression.apply(input);
  }

  /**
   * A dynamic switch-expression. It takes in a set of predicate/operation combinations in the form of an "AppendingStatement".
   * It should be noted that a FluentJ switch expression takes the English language quite literally.
   * This function is really flexible and as a result, it will not tell you if you've forgotten to state a default returning action at compile time.
   * It will, however, throw an "IncompleteStatementException" at runtime if the statement is incomplete to still catch bugs like this as early as possible.
   * To be clear: an incomplete statement would be something like this, which would cause a compile-time error
   *
   * @param expression           the initial expression, take a look at the "Expressions" to get an idea of the possibilities.
   * @param expressionExtensions the extra expression until it is complete, take a look at the "Expressions.class" to get an idea of the possibilities.
   * @param <T>                  the type of the input of the switch-expression.
   * @param <R>                  the return type of the switch expression.
   * @return the expression.
   */
  @SafeVarargs
  public static <T, R> Expression<T, R> inCaseThatIt(final Expression<T, R> expression, final Expression<T, R>... expressionExtensions) {
    if (expressionExtensions != null && expressionExtensions.length > 0) {
      for (var statementExtension : expressionExtensions) {
        expression.append(statementExtension);
      }
    }
    if (!expression.isComplete())
      throw new IncompleteExpressionException();
    return expression;
  }


//
//  public static <T> ConnectingConsumer<T> inCaseThat(final Predicate<T> predicate, Consumer<T> consumer) {
//    return it -> {
//      if (predicate.test(it))
//        consumer.accept(it);
//    };
//  }
//
//  public static <T> ConnectingConsumer<T> inCaseThat(final Predicate<T> predicate, ConnectingConsumer<T> consumer) {
//    return it -> {
//      if (predicate.test(it))
//        consumer.accept(it);
//    };
//  }

}
