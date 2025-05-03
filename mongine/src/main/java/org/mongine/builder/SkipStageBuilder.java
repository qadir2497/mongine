package org.mongine.builder;

import org.mongine.MongoDocument;
import org.mongine.exception.MongoQueryException;
import org.mongine.utils.Constants;

public class SkipStageBuilder extends BaseStageBuilder {

  private Integer skip;

  public SkipStageBuilder() {
    super.baseDocument = new MongoDocument();
  }

  public SkipStageBuilder setSkip(Integer skip) {
    this.skip = skip;
    return this;
  }

  public MongoDocument build() {
    if(skip == null) {
      throw new MongoQueryException("Please set skip value.", new Throwable("Skip not set"));
    }
    return new MongoDocument(Constants.OperatorContstants.SKIP, this.skip);
  }

}
