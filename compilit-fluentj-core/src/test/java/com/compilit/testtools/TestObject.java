package com.compilit.testtools;

public class TestObject<T> {
  private T value;
  private boolean hasBeenInteractedWith = false;
  private TestObject(T value) {
    this.value = value;
  }
  public static <T> TestObject<T> withValue(T value) {
    return new TestObject<>(value);
  }

  public T getValue() {
    return value;
  }

  public void interact() {
    hasBeenInteractedWith = true;
  }

  public void interact(T newValue) {
    hasBeenInteractedWith = true;
    value = newValue;
  }

  public boolean hasBeenInteractedWith() {
    return hasBeenInteractedWith;
  }

}
