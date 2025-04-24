package org.mongine;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MongoStatsCollection implements Aggregator {

  private final static Logger.ALogger logger = Logger.of(MongoStatsCollection.class);
  private MongoCollection<Document> collection;
  private String shardDbUrl;

  public MongoStatsCollection() {}

  @Override
  public AggregateIterable<Document> aggregate(List<Document> pipeline) {
    return this.collection.aggregate(pipeline);
  }

  public MongoStatsCollection getCollection(String shardDbUrl, Collections collection) {
    logger.info("getCollection:: Getting collection for shard : {}", shardDbUrl);
    if(!MONGODB_URIPREFIX.equals(shardDbUrl)) {
      this.collection = MongoConnectionManager.getMongoClient(shardDbUrl).getDatabase(StatsSourceConstants.getMongoDBName()).getCollection(collection.value());
      this.shardDbUrl = shardDbUrl;
      return this;
    } else {
      logger.error("getCollection: Empty shard url: {}");
    }
    return null;
  }

  public List<Document> executeQueryFromString(String shardDbUri, String collectionName, String operation, String queryString) {
    List<Document> results = null;
    if(!MONGODB_URIPREFIX.equals(shardDbUrl)) {
      Document cmd = new Document(operation, collectionName)
        .append("pipeline", createPipelineFromQueryString(queryString)).append("cursor", new Document());
      logger.debug("executeQueryFromString: Mongo command invoked : {}", cmd.toJson());
      Document queryResult = MongoConnectionManager.getMongoClient(shardDbUri).getDatabase(StatsSourceConstants.getMongoDBName()).runCommand(cmd);
      if (queryResult.containsKey("cursor")) {
        Document cursor = (Document) queryResult.get("cursor");
        if (cursor.containsKey("firstBatch")) {
          results = (List<Document>) cursor.get("firstBatch");
        }
      }
    } else {
      logger.error("executeQueryFromString: Empty shard url: {}");
      results = new ArrayList<>();
    }

    return results;
  }

  private List<Document> createPipelineFromQueryString(String queryString) {
    List<Document> pipelines = new ArrayList<>();
    Pattern pattern = Pattern.compile("\\$pipeline_start(.*?)\\$pipeline_end", Pattern.DOTALL);
    Matcher matcher = pattern.matcher(queryString);
    while (matcher.find()) {
      pipelines.add(Document.parse(matcher.group(1)));
    }
    return pipelines;
  }

}
