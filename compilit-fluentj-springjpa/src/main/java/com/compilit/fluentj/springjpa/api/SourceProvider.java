package com.compilit.fluentj.springjpa.api;

public interface SourceProvider<T, ID> {
  SourceBuilder<T, ID> byId(ID identifier);
}
