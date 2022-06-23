package com.compilit.fluentj.core.api.loops;

import com.compilit.fluentj.api.predicates.Predicates;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import testutil.AbstractTestWithContext;

import static com.compilit.fluentj.api.loops.LoopOperations.asLongAs;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.operations.StringOperations.appending;
import static com.compilit.fluentj.api.predicates.Predicates.inCaseThat;
import static com.compilit.fluentj.api.predicates.Predicates.itIs;
import static com.compilit.fluentj.api.predicates.Predicates.itIsNot;

class WhileLoopExampleTests extends AbstractTestWithContext {

  @Test
  void whileLoop_loopsWithoutPredicateMatch_shouldInteract() {

    startingWith("a",
            asLongAs(itIsNot("aaaaaaaaaa"), keep(appending("a"))),
            Predicates.inCaseThat(itIs("aaa"), this::interact));

    Assertions.assertThat(hasBeenInteractedWith()).isTrue();
  }

}
