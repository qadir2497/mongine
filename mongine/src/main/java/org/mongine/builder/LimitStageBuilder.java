package org.mongine.builder;

import org.mongine.MongoDocument;
import org.mongine.exception.MongoQueryException;

public class LimitStageBuilder extends BaseStageBuilder {

  private Integer limit;

  public LimitStageBuilder() {
    super.baseDocument = new MongoDocument();
  }

  public LimitStageBuilder setLimit(Integer limit) {
    this.limit = limit;
    return this;
  }

  public MongoDocument build() {
    if(limit == null) {
      throw new MongoQueryException("Please set limit value.", new Throwable("Limit not set"));
    }
    return new MongoDocument(StatsSourceConstants.OperatorContstants.LIMIT, this.limit);
  }

}
