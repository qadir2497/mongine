package org.mongine.exception;

public class StatsDataSourceException extends RuntimeException{
  public StatsDataSourceException() {super();}

  public StatsDataSourceException(String message) {super(message);}

  public StatsDataSourceException(String message, Throwable cause) {super(message, cause);
  }

  public StatsDataSourceException(Throwable cause) {
    super(cause);
  }

}