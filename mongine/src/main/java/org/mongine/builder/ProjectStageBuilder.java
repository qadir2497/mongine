package org.mongine.builder;

import org.mongine.MongoDocument;
import org.mongine.criteria.BaseCriteria;
import org.mongine.utils.Constants;

import java.util.List;

public class ProjectStageBuilder extends BaseStageBuilder {

  public ProjectStageBuilder() {
    super.baseDocument = new MongoDocument();
  }

  public ProjectStageBuilder addProjections(List<BaseCriteria> projectionCriterias) {
    MongoDocument doc = new MongoDocument();
    projectionCriterias.forEach(criteria -> {
      doc.append(criteria.getField(), criteria.getValue());
    });
    baseDocument.append(Constants.OperatorContstants.PROJECT, doc);
    return this;
  }

  public MongoDocument build() {
    return baseDocument;
  }

}
