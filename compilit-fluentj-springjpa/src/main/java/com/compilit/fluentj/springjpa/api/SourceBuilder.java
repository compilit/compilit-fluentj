package com.compilit.fluentj.springjpa.api;

import org.springframework.data.repository.CrudRepository;

public interface SourceBuilder<T, ID> {

  RuleValidationBuilder<T> in(CrudRepository<T, ID> repository);
}
