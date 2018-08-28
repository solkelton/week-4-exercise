package io.training.week4.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateConverter {

  public static Timestamp toTimestamp(String date) {
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSS");
      java.sql.Date sql = new java.sql.Date(dateFormat.parse(date).getTime());
      return new Timestamp(sql.getTime());
    } catch(Exception e) {
      System.err.println(e);
      return null;
    }
  }

}
