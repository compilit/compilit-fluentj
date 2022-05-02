package com.compilit.fluentj.core.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import testutil.AbstractTestWithContext;

import static com.compilit.fluentj.api.loops.LoopOperations.asLongAsIt;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.operations.StringOperations.appending;
import static com.compilit.fluentj.api.predicates.Predicates.andInCaseThat;
import static com.compilit.fluentj.api.predicates.Predicates.isNot;
import static com.compilit.fluentj.api.predicates.Predicates.itIs;

class FluentJWhileLoopExampleTests extends AbstractTestWithContext {

  @Test
  void whileLoop_loopsWithoutPredicateMatch_shouldInteract() {

    startingWith("a",
            asLongAsIt(isNot("aaaaaaaaaa"), keep(appending("a"))),
            andInCaseThat(itIs("aaa"), this::interact));

    Assertions.assertThat(hasBeenInteractedWith()).isTrue();
  }

}
