//package com.compilit.fluentj.api;
//
////import com.compilit.mediator.api.Command;
////import com.compilit.mediator.api.Event;
////import com.compilit.mediator.api.Query;
//
//import com.compilit.mediator.api.Command;
//import com.compilit.mediator.api.CommandDispatcher;
//import com.compilit.mediator.api.Event;
//import com.compilit.mediator.api.EventEmitter;
//import com.compilit.mediator.api.Query;
//import com.compilit.mediator.api.QueryDispatcher;
//import com.compilit.results.Result;
//
//import javax.annotation.ManagedBean;
//import java.util.function.Consumer;
//import java.util.function.Function;
//
//@ManagedBean
//public final class CQRSActions {
//
//  public static Runnable startWith(final Runnable runnable, final Runnable... runnables) {
//    return () -> {
//      runnable.run();
//      for (var r : runnables) {
//        r.run();
//      }
//    };
//  }
//
//  public static <T extends EventEmitter> Consumer<T> emit(Event event) {
//    return eventEmitter -> eventEmitter.emit(event);
//  }
//
//  public static <R, T extends CommandDispatcher> Function<T, R> dispatch(Command<R> command) {
//    return commandDispatcher -> commandDispatcher.dispatch(command);
//  }
//
//  public static <R> Result<R> dispatch(Command<R> command, Function<R, Result<R>> operation) {
//    return operation.apply(MediatorFactory.dispatch(command));
//  }
//
//  public static <R, T extends QueryDispatcher> Function<T, R> dispatch(Query<R> query) {
//    return queryDispatcher -> queryDispatcher.dispatch(query);
//  }
//
//  public static <R> Result<R> dispatch(Query<R> query, Function<R, Result<R>> operation) {
//    return operation.apply(MediatorFactory.dispatch(query));
//  }
//
//}
