package com.compilit.testtools;

final class TestContext {

  private boolean isInteractedWith;
  private int interactions = 0;

  public synchronized void interact() {
    isInteractedWith = true;
    interactions++;
  }

  public synchronized void reset() {
    isInteractedWith = false;
  }

  public boolean hasBeenInteractedWith() {
    return isInteractedWith;
  }

  public int getInteractions() {
    return interactions;
  }
}
