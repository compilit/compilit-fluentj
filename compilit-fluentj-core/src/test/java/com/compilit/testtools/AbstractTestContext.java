package com.compilit.testtools;

import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractTestContext {

  protected static final String NO_INTERACTION_FAILURE_MESSAGE = "Context has not been interacted with";
  protected static final String INTERACTION_FAILURE_MESSAGE = "Context has been interacted with";
  protected static final String INTERACTION_AMOUNT_FAILURE_MESSAGE = "Context has not been interacted with %d times";
  private final TestContext testContext = new TestContext();

  @BeforeEach
  public synchronized void reset() {
    testContext.reset();
  }

  public synchronized void interact() {
    testContext.interact();
  }

  public void assertInteraction() {
    if(!testContext.hasBeenInteractedWith())
      throw new AssertionError(String.format(NO_INTERACTION_FAILURE_MESSAGE));
  }

  public void assertNoInteraction() {
    if(testContext.hasBeenInteractedWith())
      throw new AssertionError(String.format(INTERACTION_FAILURE_MESSAGE));
  }

  public void assertInteraction(int times) {
    if(testContext.hasBeenInteractedWith() && testContext.getInteractions() == times)
      return;
    throw new AssertionError(String.format(INTERACTION_AMOUNT_FAILURE_MESSAGE, times));
  }

}
