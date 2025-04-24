package org.mongine;

import org.bson.Document;

public class MongoDocument extends Document {

  public MongoDocument() {}

  public MongoDocument(String key, Object value) {
    super(key, value);
  }
}
