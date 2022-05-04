package examples;

import org.junit.jupiter.api.Test;
import testutil.TestEnum;
import testutil.TestObject;

import java.util.List;
import java.util.function.Consumer;

import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.arithmetic.Multiplication.multiplyingItBy;
import static com.compilit.fluentj.api.expressions.ConditionalExpressions.inCaseThat;
import static com.compilit.fluentj.api.expressions.Expressions.is;
import static com.compilit.fluentj.api.expressions.Expressions.isNull;
import static com.compilit.fluentj.api.expressions.Expressions.otherwise;
import static com.compilit.fluentj.api.expressions.Expressions.otherwiseReturn;
import static com.compilit.fluentj.api.expressions.SwitchBreakers.andThenReturn;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.loops.Loops.takeEachEntryIn;
import static com.compilit.fluentj.api.operations.ConnectingOperations.and;
import static com.compilit.fluentj.api.operations.ConnectingOperations.then;
import static com.compilit.fluentj.api.operations.LoggerOperations.debugLogIt;
import static com.compilit.fluentj.api.operations.LoggerOperations.print;
import static com.compilit.fluentj.api.operations.LoggerOperations.printIt;
import static com.compilit.fluentj.api.operations.ReturningOperations.thenReturn;
import static com.compilit.fluentj.api.operations.ReturningOperations.thenReturnTheResult;
import static com.compilit.fluentj.api.operations.StringOperations.appending;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.itIsEqualTo;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.itIsGreaterThanOrEqualTo;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.itIsGreaterThen;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.itIsLessThen;
import static com.compilit.fluentj.api.predicates.Predicates.andInCaseThat;
import static com.compilit.fluentj.api.predicates.Predicates.asLongAs;
import static com.compilit.fluentj.api.predicates.Predicates.itIs;
import static com.compilit.fluentj.api.predicates.Predicates.itIsNot;
import static com.compilit.fluentj.api.predicates.Predicates.itIsNotNull;
import static com.compilit.fluentj.api.predicates.Predicates.until;
import static org.assertj.core.api.Assertions.assertThat;
import static testutil.TestEnum.ONE;
import static testutil.TestEnum.THREE;
import static testutil.TestEnum.TWO;
import static testutil.TestEnum.theCollection;

class FluentJApiExamples {

  //this is just a playground for the author, will be replaced by actual readable examples in the future
  @Test
  void whileLoopTest() {
    startingWith(0,
            keep(adding(1), asLongAs(itIsLessThen(10))), and(printIt()));
    assertThat(startingWith(0,
            keep(adding(1), asLongAs(itIsLessThen(10))),
            thenReturnTheResult()).getContents()).isEqualTo(10);
    startingWith("a",
            keep(appending("a"), asLongAs(itIsNot("aaaaaaaaaa")), andInCaseThat(itIs("aaa"), printIt())));
  }

  @Test
  void forLoopsTest() {
    //exclusive boundary
    assertThat(startingWith(100, keep(multiplyingItBy(2), until(itIsGreaterThen(100000))), thenReturnTheResult()).getContents()).isEqualTo(102400);

    var testObject = new TestObject(1);

    //exclusive boundary
    startingWith(0, keep(adding(1), until(itIsEqualTo(10)), and(testObject::changeValue)));
    //inclusive boundary
    startingWith(0, keep(adding(1), until(itIsGreaterThen(10)), and(testObject::changeValue)));
    assertThat(testObject.getValue()).isEqualTo(10);
    testObject = new TestObject(1);
    startingWith(0, keep(adding(1), until(itIsGreaterThen(10)), and(testObject::changeValue)));
    assertThat(testObject.getValue()).isEqualTo(9);
    testObject = new TestObject(1);
    startingWith(0, keep(adding(1), until(itIsGreaterThen(10)), and(testObject::increment)));
    assertThat(testObject.getValue()).isEqualTo(46);
    startingWith(1, keep(multiplyingItBy(2), until(itIsGreaterThanOrEqualTo(100))), then(printIt()));
  }

  @Test
  void ifElseStatementsTest() {
    var theInput = 10;
    inCaseThat(theInput, is(10, then(print("it's 10!"))), otherwise(print("it's not 10...")));
    inCaseThat(theInput, is(10, then(print("it is 10!"))));
    //or, to print the actual value
    inCaseThat(theInput, is(10, then(printIt())));
    //is the same as
    if (theInput == 10) {
      System.out.println("10");
    }
    //Which is shorter, but not more easily readable.
    //Returning values is also possible. The return value type is specified in the thenReturn function so it doesnt have to be the same as the input
    var result = inCaseThat(theInput,
            is(10, thenReturn("test")),
            otherwiseReturn("bla"));

  }

  @Test
  void inclusiveSwitchExpressions() {
    var theInput = 10;
    //prints 10 1 time
    inCaseThat(theInput,
            is(10, printIt()),
            is(100, printIt()),
            is(1000, printIt()),
//            matchesThat(itIsNotNull(), printIt()),
            otherwise(print("none")));
    //prints 10 3 times
    inCaseThat(theInput,
            is(10, printIt()),
            is(10, printIt()),
            is(10, printIt()),
            otherwise(print("none")));

    //defaults to none
    inCaseThat(theInput,
            is(1, printIt()),
            is(2, print("this is something else")),
            is(3, print("this is also something else")),
            otherwise(print("none")));

    //with a predicate expression, prints null
    inCaseThat(null,
            isNull(printIt()),
            is(10, printIt()),
            is(10, printIt()),
            otherwise(print("none")));
  }

  @Test
  void exclusiveSwitchExpressions() {
    var theInput = 10;
    //prints 10 only 1 time
    inCaseThat(theInput,
            is(10, printIt(), andThenReturn()),
            is(10, printIt()),
            is(10, printIt()),
            otherwise(print("none")));

    //prints 10 only 3 times
    inCaseThat(theInput,
            is(10, printIt()),
            is(10, printIt()),
            is(10, printIt(), andThenReturn()),
            is(10, printIt()),
            otherwise(print("none")));

  }

  @Test
  void iterationTest() {
    var theList = List.of("test1", "test2", "test3");
    takeEachEntryIn(theCollection(), and(printItOnCondition()));
    takeEachEntryIn(theCollection(), and(printIt()));
    takeEachEntryIn(List.of("test1", "test2", "test3"), andInCaseThat(itIsNotNull(), printIt()));
    takeEachEntryIn(theList, andInCaseThat(itIsNotNull(), printIt()));
    takeEachEntryIn(theList, and(debugLogIt()));
    takeEachEntryIn(theCollection(), printIt());

    var expression = inCaseThat(
            isNull(thenReturn("null")),
            is("10", thenReturn("10")),
            is("11", thenReturn("11")),
            otherwiseReturn("none"));
  }

  private static Consumer<TestEnum> printItOnCondition() {
    return theInput -> inCaseThat(theInput,
            is(ONE, print("1")),
            is(TWO, printIt()),
            is(THREE, print("3")),
            otherwise(print("none")));
  }

}
