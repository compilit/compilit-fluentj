//package com.compilit.fluentj.core;
//
//import com.compilit.fluentj.core.testutil.TestCommand;
//import com.compilit.fluentj.core.testutil.TestEvent;
//import com.compilit.fluentj.core.testutil.TestQuery;
//import org.junit.jupiter.api.Test;
//
//import static com.compilit.fluentj.api.CQRSActions.dispatch;
//import static com.compilit.fluentj.api.CQRSActions.emit;
//import static com.compilit.fluentj.api.Operations.and;
//import static com.compilit.fluentj.api.Operations.andReturnResult;
//import static com.compilit.fluentj.api.Operations.thenReturnResult;
//
//class FluentJCQRSExampleTests {
//
//  @Test
//  void emit_shouldEmitEvent() {
//    emit(new TestEvent());
//    dispatch(new TestCommand(), andReturnResult());
//    dispatch(new TestQuery(), andReturnResult());
//  }
//}
