package examples;

import com.compilit.testtools.AbstractTestContext;
import com.compilit.testtools.TestObject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.compilit.fluentj.api.arithmetic.Addition.adding;
import static com.compilit.fluentj.api.arithmetic.Multiplication.*;
import static com.compilit.fluentj.api.expressions.ConditionalExpressions.inCaseThat;
import static com.compilit.fluentj.api.expressions.ConditionalExpressions.inCaseThatIt;
import static com.compilit.fluentj.api.expressions.Expressions.*;
import static com.compilit.fluentj.api.expressions.SwitchBreakers.andThenReturn;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.loops.Loops.takeEachEntryIn;
import static com.compilit.fluentj.api.operations.ConnectingOperations.and;
import static com.compilit.fluentj.api.operations.ConnectingOperations.then;
import static com.compilit.fluentj.api.operations.LoggerOperations.*;
import static com.compilit.fluentj.api.operations.ReturningOperations.thenReturn;
import static com.compilit.fluentj.api.operations.ReturningOperations.thenReturnTheResult;
import static com.compilit.fluentj.api.operations.StringOperations.appending;
import static com.compilit.fluentj.api.predicates.IntegerPredicates.*;
import static com.compilit.fluentj.api.predicates.Predicates.asLongAs;
import static com.compilit.fluentj.api.predicates.Predicates.inCaseThat;
import static com.compilit.fluentj.api.predicates.Predicates.itIs;
import static com.compilit.fluentj.api.predicates.Predicates.itIsNot;
import static com.compilit.fluentj.api.predicates.Predicates.itIsNotNull;
import static com.compilit.fluentj.api.predicates.Predicates.until;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class FluentJApiExampleTest extends AbstractTestContext {

    //this is just a playground for the author, will be replaced by actual readable examples in the future
    @Test
    void whileLoopTest() {
        startingWith(0,
                keep(adding(1), asLongAs(itIsLessThen(10))), and(printIt()));
        assertThat(startingWith(0,
                keep(adding(1), asLongAs(itIsLessThen(10))),
                thenReturnTheResult()).getContents()).isEqualTo(10);
        startingWith("a",
                keep(appending("a"), asLongAs(itIsNot("aaaaaaaaaa")), inCaseThat(itIs("aaa"), printIt())));
    }

    @Test
    void forLoopsTest() {
        assertThat(startingWith(100, keep(multiplyingItBy(2), until(itIsGreaterThan(100000))), thenReturnTheResult()).getContents()).isEqualTo(102400);

        var testObject = TestObject.withValue(1);

        //exclusive boundary
        startingWith(0, keep(adding(1), until(itIsEqualTo(10)), and(this::interact)));
        //inclusive boundary
        startingWith(0, keep(adding(1), until(itIsGreaterThan(10)), and(this::interact)));
        assertThat(testObject.getValue()).isEqualTo(10);
        testObject = TestObject.withValue(1);
        startingWith(0, keep(adding(1), until(itIsGreaterThan(10)), and(this::interact)));
        assertThat(testObject.getValue()).isEqualTo(10);
        testObject = TestObject.withValue(1);
        startingWith(0, keep(adding(1), until(itIsGreaterThan(10)), and(this::interact)));
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
        takeEachEntryIn(theList, and(printIt()));
        takeEachEntryIn(List.of("test1", "test2", "test3"), and(inCaseThat(itIsNotNull(), printIt())));
        takeEachEntryIn(theList, and(inCaseThat(itIsNotNull(), printIt())));
        takeEachEntryIn(theList, and(debugLogIt()));

        var expression = inCaseThatIt(
                isNull(thenReturn("null")),
                is("10", thenReturn("10")),
                is("11", thenReturn("11")),
                otherwiseReturn("none"));

        assertThat(expression.apply("10")).isEqualTo("10");
    }

}
