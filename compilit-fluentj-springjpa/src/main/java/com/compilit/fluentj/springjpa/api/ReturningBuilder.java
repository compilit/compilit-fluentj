package com.compilit.fluentj.springjpa.api;

import java.util.function.Function;

public interface ReturningBuilder<T> {

  <T> R andReturn(Function<T> function);
}
