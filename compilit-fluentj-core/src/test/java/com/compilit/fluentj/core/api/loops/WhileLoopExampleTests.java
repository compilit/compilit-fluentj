package com.compilit.fluentj.core.api.loops;

import com.compilit.testtools.AbstractTestContext;
import org.junit.jupiter.api.Test;

import static com.compilit.fluentj.api.loops.LoopOperations.asLongAs;
import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.operations.StringOperations.appending;
import static com.compilit.fluentj.api.predicates.Predicates.*;

class WhileLoopExampleTests extends AbstractTestContext {

  @Test
  void whileLoop_loopsWithoutPredicateMatch_shouldInteract() {

    startingWith("a",
            asLongAs(itIsNot("aaaaaaaaaa"), keep(appending("a"))),
            inCaseThat(itIs("aaa"), this::interact));

    assertInteraction();
  }

}
