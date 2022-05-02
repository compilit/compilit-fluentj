//package com.compilit.fluentj.core.api;
//
//import com.compilit.fluentj.api.operations.ConnectingOperations;
//import com.compilit.validation.api.contracts.Rule;
//import org.junit.jupiter.api.Test;
//
//import java.util.function.Predicate;
//
//import static com.compilit.fluentj.api.datastructures.Creations.createA;
//import static com.compilit.fluentj.api.operations.ConnectingOperations.and;
//import static com.compilit.validation.api.Definitions.defineThatIt;
//
//class FluentJCreationApiTests {
//
//  private final Rule<Object> rookRule = defineThatIt(canMoveTwoStepsForwardAndOneStepLeft()
//          .and(canMoveTwoStepsBackwardAndOneStepLeft())
//          .and(canMoveTwoStepsForwardAndOneStepRight())
//          .and(canMoveTwoStepsBackwardAndOneStepRight())
//          .and(canMoveTwoStepsLeftAndOneStepForward())
//          .and(canMoveTwoStepsLeftAndOneStepBackward())
//          .and(canMoveTwoStepsRightAndOneStepForward())
//          .and(canMoveTwoStepsRightAndOneStepBackward())).otherwiseReport("rook move rule broken");
//
//  private Predicate<Object> canMoveTwoStepsBackwardAndOneStepLeft() {
//    return it -> ;
//  }
//
//  private Predicate<Object> canMoveTwoStepsForwardAndOneStepRight() {
//    return it -> ;
//  }
//
//  private Predicate<Object> canMoveTwoStepsBackwardAndOneStepRight() {
//    return it -> ;
//  }
//
//  private Predicate<Object> canMoveTwoStepsLeftAndOneStepForward() {
//    return it -> ;
//  }
//
//  private Predicate<Object> canMoveTwoStepsLeftAndOneStepBackward() {
//    return it -> ;
//  }
//
//  private Predicate<Object> canMoveTwoStepsRightAndOneStepForward() {
//    return it -> ;
//
//  }
//
//  private Predicate<Object> canMoveTwoStepsRightAndOneStepBackward() {
//    return it -> ;
//  }
//
//  private Predicate<Object> canMoveTwoStepsForwardAndOneStepLeft() {
//    return it -> ;
//  }
//
//  @Test
//  void create() {
//    createA("rook", )
//  }
//}
