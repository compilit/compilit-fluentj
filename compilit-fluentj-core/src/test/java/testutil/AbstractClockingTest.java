package testutil;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.time.OffsetDateTime;

public abstract class AbstractClockingTest {

  protected long startingTime;

  @BeforeEach
  void setup() {
    startingTime = OffsetDateTime.now().getNano();
  }

  @AfterEach
  void finish() {
    long endTime = OffsetDateTime.now().getNano();
    System.out.printf("Duration in milliseconds: %f", (endTime - startingTime) / 1000000f);
  }
}
