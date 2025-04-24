package org.mongine.builder;

import org.mongine.MongoDocument;
import org.mongine.exception.MongoQueryException;
import org.mongine.criteria.BaseCriteria;

public class BaseStageBuilder {
  public MongoDocument baseDocument;

  public MongoDocument getRawMongoDocument(BaseCriteria criteria) {
    return new MongoDocument(criteria.getField(), criteria.getValue());
  }

  public Tuple2<BaseStageBuilder, MongoDocument> getMongoDocumentToAppend(BaseCriteria criteria) {
    return new Tuple2(this, new MongoDocument(criteria.getField(), criteria.getValue()));
  }

  public MongoDocument append(MongoDocument doc, BaseCriteria criteria) {
    if(doc == null) {
      throw new MongoQueryException("Null MongoDocument cannot be appended.");
    }
    doc.append(criteria.getField(), criteria.getValue());
    return doc;
  }

}
