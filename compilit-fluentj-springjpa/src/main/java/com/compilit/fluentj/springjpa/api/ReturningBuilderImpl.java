//package com.compilit.fluentj.springjpa.api;
//
//import java.util.function.Function;
//
//public class ReturningBuilderImpl<T> implements ReturningBuilder<T> {
//
//  private final EntitySubject<T> subject;
//
//  public ReturningBuilderImpl(EntitySubject<T> subject) {
//    this.subject = subject;
//  }
//
//  @Override
//  public <T> R andReturn(Function<T> function) {
//    if (subject.isValid()) {
//      return function.apply(subject.save());
//    }
//    return null;
//  }
//}
