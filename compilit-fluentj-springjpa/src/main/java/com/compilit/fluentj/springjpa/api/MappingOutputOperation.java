package com.compilit.fluentj.springjpa.api;

public interface MappingOutputOperation<T, ID> {
  SourceBuilder<T, ID> andThenCreate();
}
