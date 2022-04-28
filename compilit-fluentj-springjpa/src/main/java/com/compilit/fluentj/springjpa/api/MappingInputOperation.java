package com.compilit.fluentj.springjpa.api;

public interface MappingInputOperation<T, ID> {
  MappingOutputOperation<T, ID> to();
}
