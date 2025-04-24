package org.mongine.exception;

public class MongoQueryException extends RuntimeException {

  public MongoQueryException() {
    super();
  }

  public MongoQueryException(String message) {
    super(message);
  }

  public MongoQueryException(String message, Throwable cause) {
    super(message, cause);
  }

  public MongoQueryException(Throwable cause) {
    super(cause);
  }
}