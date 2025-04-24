package org.mongine;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoConnectionManager {

  private final static Logger.ALogger logger = Logger.of(MongoConnectionManager.class);

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
