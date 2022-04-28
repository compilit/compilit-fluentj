package testutil;

public class TestObject {

  private int value;

  public TestObject(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void increment(int increment) {
    value += increment;
  }

  public void changeValue(int newValue) {
    value = newValue;
  }

}
