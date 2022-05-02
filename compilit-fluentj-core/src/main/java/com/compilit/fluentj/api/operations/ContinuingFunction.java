package com.compilit.fluentj.api.operations;

import java.util.function.Function;

@FunctionalInterface
public interface ContinuingFunction<T, R> extends Function<T, R> {
}
