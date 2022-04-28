package testutil;

import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractTestWithContext {

  private final TestContext testContext = new TestContext();
  protected String expected = "expected";
  protected String notExpected = "not expected";

  @BeforeEach
  public synchronized void reset() {
    testContext.reset();
  }

  public synchronized void interact() {
    testContext.interact();
  }

  public synchronized boolean interactAndReturn() {
    testContext.interact();
    return true;
  }

  public boolean hasBeenInteractedWith() {
    return testContext.hasBeenInteractedWith();
  }

  public boolean hasBeenInteractedWith(int times) {
    return testContext.hasBeenInteractedWith() && testContext.interactionCount() == times;
  }

}
