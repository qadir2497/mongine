package org.mongine;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoConnectionManager {

  private final static Logger logger = LoggerFactory.getLogger(MongoConnectionManager.class);

  private static MongoClient mongoClient;

  private MongoConnectionManager() {}

  public static MongoClient getMongoClient(String shardDbUrl) {
    if (mongoClient == null) {
      synchronized (MongoConnectionManager.class) {
        if (mongoClient == null) {
          mongoClient = MongoClients.create(shardDbUrl);
        }
      }
    }
    logger.debug("getMongoClient:: Connected to mongo client with url {} ", shardDbUrl);
    return mongoClient;
  }

}
