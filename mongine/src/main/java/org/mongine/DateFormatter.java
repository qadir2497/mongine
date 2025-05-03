package org.mongine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatter {

  private final static Logger logger = LoggerFactory.getLogger(DateFormatter.class);

  public static String getSimpleDateFormat(Date date, Format format) {
    DateFormat dateFormat = new SimpleDateFormat(format.value());
    return dateFormat.format(date);
  }

  public static String getFlowsDateFormat(Date date) {
    SimpleDateFormat isoFormat = new SimpleDateFormat(Format.YYYY_MM_DD.value());
    isoFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    String newDate = null;
    try {
      newDate = isoFormat.format(date);
    } catch (Exception e) {
      logger.error("getFlowsDateFormat:: Error parsing date: " + e.getMessage());
    }
    return "ISODate('" + newDate + "')";

  }

  public enum Format {
    YYYY_MM_DD("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"),
    INTERVAL_MIN("%Y-%m-%dT%H:%M:00.000Z"),
    INTERVAL_FIVE_MIN("five_min"), // Creating custom format as no defined format is available for five min in Mongo Pipeline aggregation.
    INTERVAL_HOUR("%Y-%m-%dT%H:00:00.000Z"),
    INTERVAL_DAY("%Y-%m-%dT00:00:00.000Z"),
    INTERVAL_MONTH("%Y-%m-01T00:00:00.000Z");

    private final String value;
    Format(String value) {
      this.value = value;
    }
    public String value() {
      return this.value;
    }
  }

}
