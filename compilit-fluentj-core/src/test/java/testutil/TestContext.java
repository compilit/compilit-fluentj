package testutil;

final class TestContext {

  private boolean isInteractedWith;
  private int counter = 0;

  TestContext() {
  }

  public synchronized void interact() {
    isInteractedWith = true;
    counter++;
  }

  public synchronized void reset() {
    isInteractedWith = false;
  }

  public boolean hasBeenInteractedWith() {
    return isInteractedWith;
  }

  public int interactionCount() {
    return counter;
  }
}
