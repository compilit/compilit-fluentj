package com.compilit.fluentj.api.expressions;

import java.util.function.Consumer;
import java.util.function.Function;

public interface SwitchBreaker<T, R> {

  R apply(T input);

}
