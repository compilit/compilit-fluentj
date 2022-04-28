package com.compilit.fluentj.springjpa.api;

import java.util.List;
import java.util.function.Predicate;

public interface RuleValidationBuilder<T> {

  ReturningBuilder<T> afterValidating(List<Predicate<T>> rules);
}
