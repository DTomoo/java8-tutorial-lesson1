package com.dt.tutorial.java8.lesson1;

public class EnumExample {

  public static void main(String[] args) throws Exception {

    EnumParser<Status> enumParser = (bc) -> Enum.valueOf(Status.class, "STATUS_" + bc);
    
    Status status00 = enumParser.getEnum("00");
    System.out.println(status00);
    
    Status status05 = enumParser.getEnum("05");
    System.out.println(status05);
  }

  private static enum Status {
    STATUS_00, STATUS_01, STATUS_02;
  }

  @FunctionalInterface
  private interface EnumParser<T extends Enum<T>> {

    // only one not-default method
    public T getEnum(String enumString) throws Exception;

    public default String getDefaultText() {

      return "default";
    }
  }
}
