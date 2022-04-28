package com.compilit.fluentj.core.api;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testutil.TestEnum;
import testutil.TestObject;

import java.util.List;
import java.util.function.Consumer;

import static com.compilit.fluentj.api.operations.ConditionalOperations.then;
import static com.compilit.fluentj.api.expressions.ConditionalExpressions.inCaseThat;
import static com.compilit.fluentj.api.operations.ConnectingOperations.and;
import static com.compilit.fluentj.api.operations.DefaultReturningOperations.otherwise;
import static com.compilit.fluentj.api.operations.DefaultReturningOperations.otherwiseReturn;
import static com.compilit.fluentj.api.expressions.Expressions.is;
import static com.compilit.fluentj.api.expressions.Expressions.isAnyThingElseThen;
import static com.compilit.fluentj.api.expressions.Expressions.isAnyThingElseThenReturn;
import static com.compilit.fluentj.api.expressions.Expressions.isNull;
import static com.compilit.fluentj.api.expressions.Expressions.matchesThatIt;
import static com.compilit.fluentj.api.operations.LoggerOperations.debugLog;
import static com.compilit.fluentj.api.operations.LoggerOperations.errorLog;
import static com.compilit.fluentj.api.operations.LoggerOperations.infoLog;
import static com.compilit.fluentj.api.operations.LoggerOperations.print;
import static com.compilit.fluentj.api.operations.LoggerOperations.printIt;
import static com.compilit.fluentj.api.operations.LoggerOperations.warningLog;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.eachEntry;
import static com.compilit.fluentj.api.loops.Loops.eachEntryIn;
import static com.compilit.fluentj.api.loops.Loops.forEachEntryIn;
import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.loops.Loops.startingWithA;
import static com.compilit.fluentj.api.loops.Loops.takeEachEntryIn;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.untilReachingOrGoingAbove;
import static com.compilit.fluentj.api.predicates.Predicates.andInCaseThat;
import static com.compilit.fluentj.api.predicates.Predicates.asLongAsIt;
import static com.compilit.fluentj.api.predicates.Predicates.inCaseThatIt;
import static com.compilit.fluentj.api.predicates.Predicates.isAnyOf;
import static com.compilit.fluentj.api.predicates.Predicates.isNot;
import static com.compilit.fluentj.api.predicates.Predicates.isNotNull;
import static com.compilit.fluentj.api.predicates.Predicates.itIs;
import static com.compilit.fluentj.api.predicates.Predicates.untilIt;
import static com.compilit.fluentj.api.operations.ReturningOperations.thenReturn;
import static com.compilit.fluentj.api.operations.ReturningOperations.thenReturnTheResult;
import static com.compilit.fluentj.api.operations.StringOperations.appending;
import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.arithmetic.Multiplication.multiplyingItBy;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.isLessThen;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.isMoreThenOrEqualTo;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.untilGoingAbove;
import static org.assertj.core.api.Assertions.assertThat;
import static testutil.TestEnum.ONE;
import static testutil.TestEnum.THREE;
import static testutil.TestEnum.TWO;
import static testutil.TestEnum.theCollection;

class FluentJApiExampleTests {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Test
  void whileLoopTest() {
//    startingWith(0, keep(adding(1), asLongAsIt(isLessThen(10))), and(printIt()));
////    startingWith(0, keep(adding(1), asLongAsIt(isLessThen(10)))).and(printIt());
//    startingWith(0, keep(adding(1), asLongAsIt(isLessThen(10))), and(printIt()));
    assertThat(startingWith(0, keep(adding(1), asLongAsIt(isLessThen(10))), thenReturnTheResult()).getContents()).isEqualTo(10);
//    assertThat(startingWith(0, keep(adding(1), asLongAsIt(isLessThen(10)))).thenReturnResultContents().get()).isEqualTo(10);
//    assertThat(startingWith(0, keep(adding(1), asLongAsIt(isLessThen(10)))).thenReturnValue()).isEqualTo(10);
//    startingWith(0, keep(adding(1), asLongAsIt(isLessThen(10)))).andInCaseThat(x -> true, printIt());
    startingWith("a", keep(appending("a"), asLongAsIt(isNot("aaaaaaaaaa"))), andInCaseThat(itIs("aaa"), printIt()));
    startingWith("a", keep(appending("a"), asLongAsIt(isNot("aaaaaaaaaa"))), andInCaseThat(itIs("aaa"), then(printIt())));
//    assertThat(startingWith(0, keep(adding(1), asLongAsIt(isLessThen(10)))).unless(x -> true)).isFalse();
  }

  @Test
  void forLoopsTest() {
    //exclusive boundary
    assertThat(startingWith(100, keep(multiplyingItBy(2), untilGoingAbove(100000)), thenReturnTheResult()).getContents()).isEqualTo(102400);

    var testObject = new TestObject(1);
    //inclusive boundary
    startingWith(0, keep(adding(1), untilGoingAbove(10)), and(testObject::changeValue));
    assertThat(testObject.getValue()).isEqualTo(10);
    testObject = new TestObject(1);
    startingWith(0, keep(adding(1), untilReachingOrGoingAbove(10)), and(testObject::changeValue));
    assertThat(testObject.getValue()).isEqualTo(9);
    testObject = new TestObject(1);
    startingWith(0, keep(adding(1), untilReachingOrGoingAbove(10)), and(testObject::increment));
    assertThat(testObject.getValue()).isEqualTo(46);
    startingWith(1, keep(multiplyingItBy(2), untilIt(isMoreThenOrEqualTo(100))), then(printIt()));
  }

  @Test
  void ifElseStatementsTest() {
    var theInput = 10;
    inCaseThat(theInput, is(10, then(print("it's 10!"))), isAnyThingElseThen(print("it's not 10...")));
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
            isAnyThingElseThenReturn("bla"));

  }
  @Test
  void switchTest() {
    //Inclusive switch expression
    var theInput = 10;
    //prints 10 1 time
    inCaseThat(theInput,
            is(10, printIt()),
            is(100, printIt()),
            is(1000, printIt()),
            matchesThatIt(isNotNull(), printIt()),
            isAnyThingElseThen(print("none")));
    //prints 10 3 times
    inCaseThat(theInput,
            is(10, printIt()),
            is(10, then(printIt())),
            is(10, printIt()),
            isAnyThingElseThen(print("none")));

    //with a predicate expression
    inCaseThat(null,
            isNull(printIt()),
            is(10, printIt()),
            is(10, printIt()),
            isAnyThingElseThen(print("none")));

    inCaseThat(theInput, isAnyOf(10, 100, 1000), then(printIt()));
    inCaseThat(theInput, isAnyOf(10, 100, 1000), then(printIt()));
    var actual = inCaseThat(theInput, isAnyOf(10, 100, 1000), thenReturn(100), otherwiseReturn(1));
    assertThat(actual).isEqualTo(100);

    inCaseThat(THREE, isAnyOf(ONE, TWO), then(printIt()));
    var actual3 = inCaseThat(ONE, isAnyOf(ONE, TWO) , thenReturn(100), otherwiseReturn(1));
    assertThat(actual3).isEqualTo(100);

    inCaseThat(theInput, isAnyOf(10, 11, 113123), then(print("yay")), otherwise(print("nay")));
  }

  @Test
  void iterationTest() {
    var theList = List.of("test1", "test2", "test3");
    forEachEntryIn(theCollection(), printItOnCondition());
    takeEachEntryIn(theCollection(), and(printItOnCondition()));
    forEachEntryIn(theCollection(), printIt());
    startingWithA(List.of("test1", "test2", "test3"), print(eachEntry(inCaseThatIt(isNotNull()))));
    startingWithA(List.of("test1", "test2", "test3"), print(eachEntry(inCaseThatIt(isNotNull()))));
    print(eachEntryIn(theList), inCaseThatIt(isNotNull()));
    debugLog(eachEntryIn(theList));
    infoLog(eachEntryIn(theList));
    warningLog(eachEntryIn(theList));
    errorLog(eachEntryIn(theList));
  }

  @Test
  void CQRSTest() {
    //    dispatch()
//    emit()
//    startWith()
//    var result1 = startWith(() -> System.out.println("test"))
//            .and(() -> logger.info("logtest"))
//            .andThenDispatch(new TestCommand()).thenReturnResult();
//    var result2 = dispatch(new TestQuery()).thenReturnResult();
//    var result3 = emit(new TestEvent()).thenReturnResult();
//    var result4 = emit(new TestEvent()).thenReturnResponseEntityBasedOnResult();
  }


  private static Consumer<TestEnum> printItOnCondition() {
    return theInput -> inCaseThat(theInput,
            is(ONE, print("1")),
            is(TWO, printIt()),
            is(THREE, print("3")),
            isAnyThingElseThen(print("none")));
  }

}
