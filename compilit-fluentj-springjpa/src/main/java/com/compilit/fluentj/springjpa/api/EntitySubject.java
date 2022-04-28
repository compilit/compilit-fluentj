//package com.compilit.fluentj.springjpa.api;
//
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.List;
//import java.util.function.Predicate;
//
//public class EntitySubject<T, ID> {
//
//  private final T input;
//  private final ID identifier;
//  private List<Predicate<T>> predicates;
//  private CrudRepository<T, ?> repository;
//
//  public EntitySubject(T input) {
//    this.input = input;
//    this.identifier = null;
//  }
//
//  public EntitySubject(ID identifier) {
//    this.input = null;
//    this.identifier = identifier;
//  }
//
//  public T save() {
//    return repository.save(input);
//  }
//
//  public void setRepository(CrudRepository<T, ?> repository) {
//    this.repository = repository;
//  }
//
//  public void addValidations(List<Predicate<T>> rules) {
//    this.predicates = rules;
//  }
//
//  public boolean isValid() {
//    return predicates.stream().allMatch(x -> x.test(input));
//  }
//}
