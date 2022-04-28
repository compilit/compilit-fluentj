//package com.compilit.fluentj.springjpa.api;
//
//import java.util.List;
//import java.util.function.Predicate;
//
//public class EntityRuleValidationBuilder<T> implements RuleValidationBuilder<T> {
//
//  private final EntitySubject<T> subject;
//
//  public EntityRuleValidationBuilder(EntitySubject<T> subject) {
//    this.subject = subject;
//  }
//
//  @Override
//  public ReturningBuilder<T> afterValidating(List<Predicate<T>> rules) {
//    subject.addValidations(rules);
//    return new ReturningBuilderImpl<>(subject);
//  }
//}
