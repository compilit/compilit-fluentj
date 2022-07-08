package com.compilit.testtools;

public final class TestValues {

  public static final String NULL_STRING = null;
  public static final String STRING_VALUE = "test value";
  public static final String DEFAULT_STRING_VALUE = "default test value";
  public static final int INT_VALUE = 1;
  public static final int DEFAULT_INT_VALUE = 9;

  public static final float FLOAT_VALUE = .1f;
  public static final float DEFAULT_FLOAT_VALUE = .9f;

  public static final double DOUBLE_VALUE = .1;
  public static final double DEFAULT_DOUBLE_VALUE = .9;

  public static final String NUMERIC_STRING_VALUE = String.valueOf(INT_VALUE);
  public static final String DEFAULT_NUMERIC_STRING_VALUE = String.valueOf(DEFAULT_INT_VALUE);

  private TestValues() {}

}
