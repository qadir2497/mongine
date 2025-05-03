package org.mongine.builder;

import org.mongine.MongoDocument;
import org.mongine.criteria.BaseCriteria;
import org.mongine.utils.Constants;

import java.util.List;

public class SortStageBuilder extends BaseStageBuilder {

  public SortStageBuilder() {
    super.baseDocument = new MongoDocument();
  }

  public SortStageBuilder addSorts(List<BaseCriteria> sortCriterias) {
    MongoDocument doc = new MongoDocument();
    sortCriterias.forEach(criteria -> {
      doc.append(criteria.getField(), criteria.getValue());
    });
    baseDocument.append(Constants.OperatorContstants.SORT, doc);
    return this;
  }

  public MongoDocument build() {
    return baseDocument;
  }

}
