package org.mongine.builder;

import org.mongine.MongoDocument;
import org.mongine.criteria.BaseCriteria;

import java.util.List;

public class GroupStageBuilder extends BaseStageBuilder {

  private MongoDocument groupStage;

  public GroupStageBuilder() {
    this.groupStage = new MongoDocument();
  }

  public GroupStageBuilder groupByList(List<BaseCriteria> groupCriteria) {
    MongoDocument doc = new MongoDocument();
    groupCriteria.forEach(criteria -> {
      doc.append(criteria.getField(), criteria.getValue());
    });
    groupStage.append("_id", doc);
    return this;
  }

  public GroupStageBuilder groupByValue(String groupCriteria) {
    groupStage.append("_id", groupCriteria);
    return this;
  }

  public GroupStageBuilder addAccumulator(List<BaseCriteria> groupCriteria) {
    groupCriteria.forEach(criteria -> {
      groupStage.append(criteria.getField(), criteria.getValue());
    });
    return this;
  }

  public GroupStageBuilder addAccumulator(BaseCriteria groupCriteria) {
    groupStage.append(groupCriteria.getField(), groupCriteria.getValue());
    return this;
  }

  public MongoDocument build() {
    return new MongoDocument(StatsSourceConstants.OperatorContstants.GROUP, groupStage);
  }

}
