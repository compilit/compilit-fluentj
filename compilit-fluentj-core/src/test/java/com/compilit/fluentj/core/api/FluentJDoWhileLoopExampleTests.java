package com.compilit.fluentj.core.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import testutil.AbstractTestWithContext;

import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.operations.StringOperations.appending;
import static com.compilit.fluentj.api.predicates.Predicates.andInCaseThat;
import static com.compilit.fluentj.api.predicates.Predicates.asLongAsIt;
import static com.compilit.fluentj.api.predicates.Predicates.isNot;
import static com.compilit.fluentj.api.predicates.Predicates.itIs;

class FluentJDoWhileLoopExampleTests extends AbstractTestWithContext {

  @Test
  void doWhileLoop_loopsWithPredicateMatch_shouldInteract() {
    startingWith("a", keep(appending("a"), asLongAsIt(isNot("aaaaaaaaaa"))), andInCaseThat(itIs("aaa"), this::interact));
    Assertions.assertThat(hasBeenInteractedWith()).isTrue();
  }

  @Test
  void doWhileLoop_loopsWithoutPredicateMatch_shouldNotInteract() {
    startingWith("a", keep(appending("a"), asLongAsIt(isNot("aaaaaaaaaa"))), andInCaseThat(itIs("something that doens't exist"), this::interact));
    Assertions.assertThat(hasBeenInteractedWith()).isFalse();
  }

}
