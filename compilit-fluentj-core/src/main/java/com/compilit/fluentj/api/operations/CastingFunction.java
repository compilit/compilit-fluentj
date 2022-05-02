package com.compilit.fluentj.api.operations;

import java.util.function.Function;

@FunctionalInterface
public interface CastingFunction<T, R> extends Function<T, R> {
}
