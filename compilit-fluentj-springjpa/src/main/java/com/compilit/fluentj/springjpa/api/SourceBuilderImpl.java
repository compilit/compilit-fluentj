//package com.compilit.fluentj.springjpa.api;
//
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.function.Consumer;
//
//public class SourceBuilderImpl<T> implements SourceBuilder<T> {
//
//  private final EntitySubject<T> subject;
//
//  public SourceBuilderImpl(EntitySubject<T> subject) {
//    this.subject = subject;
//  }
//
//  @Override
//  public <ID> RuleValidationBuilder<T> in(CrudRepository<T, ID> repository) {
//    subject.setRepository(repository);
//    return new EntityRuleValidationBuilder<>(subject);
//  }
//}
