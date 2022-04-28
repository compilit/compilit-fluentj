//package com.compilit.fluentj.springjpa.api;
//
//import java.util.function.Consumer;
//import java.util.function.Function;
//
//public class SourceProviderImpl<T, ID> implements SourceProvider<T, ID> {
//
//  private final Function<ID, EntitySubject<T>> idProvider;
//
//  public SourceProviderImpl(Function<ID, EntitySubject<T>> idProvider) {
//    this.idProvider = idProvider;
//  }
//
//  @Override
//  public SourceBuilder<T> byId(ID identifier) {
//    return new SourceBuilderImpl<>(idProvider.apply(identifier));
//  }
//}
