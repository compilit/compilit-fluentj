package testutil;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum TestEnum {
  ONE,
  TWO,
  THREE;

  public static Collection<TestEnum> theCollection() {
    return Stream.of(values()).collect(Collectors.toList());
  }
}
