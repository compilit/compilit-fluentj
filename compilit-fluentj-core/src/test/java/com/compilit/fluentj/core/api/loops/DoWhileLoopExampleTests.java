package com.compilit.fluentj.core.api.loops;

import com.compilit.fluentj.api.predicates.Predicates;
import com.compilit.testtools.AbstractTestContext;
import org.junit.jupiter.api.Test;

import static com.compilit.fluentj.api.loops.LoopOperations.keep;
import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.operations.StringOperations.appending;
import static com.compilit.fluentj.api.predicates.Predicates.*;

class DoWhileLoopExampleTests extends AbstractTestContext {

  @Test
  void doWhileLoop_loopsWithPredicateMatch_shouldInteract() {
    startingWith("a", keep(appending("a"), asLongAs(itIsNot("aaaaaaaaaa"))), Predicates.inCaseThat(itIs("aaa"), this::interact));
    assertInteraction();
  }

  @Test
  void doWhileLoop_loopsWithoutPredicateMatch_shouldNotInteract() {
    startingWith("a", keep(appending("a"), asLongAs(itIsNot("aaaaaaaaaa"))), Predicates.inCaseThat(itIs("something that doens't exist"), this::interact));
    assertNoInteraction();
  }

}
