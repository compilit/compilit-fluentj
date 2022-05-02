package com.compilit.fluentj.api.operations;

import java.util.function.Function;
@FunctionalInterface
public interface ConnectingFunction<T, R> extends Function<T, R> {
}
