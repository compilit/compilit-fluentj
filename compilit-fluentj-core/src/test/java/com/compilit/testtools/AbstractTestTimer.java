package com.compilit.testtools;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoField;

public abstract class AbstractTestTimer {

  protected long startingTime;

  @BeforeEach
  void setup() {
    startingTime = OffsetDateTime.now().getLong(ChronoField.MILLI_OF_DAY);
  }

  @AfterEach
  void finish() {
    var endTime = OffsetDateTime.now().getLong(ChronoField.MILLI_OF_DAY);
    var result = endTime - startingTime;
    System.out.printf("Duration in milliseconds: %d", result);
  }
}
