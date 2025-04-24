package org.mongine;

import com.mongodb.client.AggregateIterable;
import org.bson.Document;

import java.util.List;

public interface Aggregator{
  AggregateIterable<Document> aggregate(List<Document> pipeline);
}
