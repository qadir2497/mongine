package org.mongine.builder;

import org.mongine.MongoDocument;
import org.mongine.criteria.BaseCriteria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchStageBuilder extends BaseStageBuilder {
  private MongoDocument matchStage;

  public MatchStageBuilder(List<BaseCriteria> matchCriteriaList) {
    MongoDocument matchDocument = new MongoDocument();
    Map<String, MongoDocument> fieldCriteriaMap = new HashMap<>();

    matchCriteriaList.forEach(criteria -> {
      fieldCriteriaMap.computeIfPresent(criteria.getField(), (key, existingDoc) -> {
        existingDoc.append(criteria.getOperator(), criteria.getValue());
        return existingDoc;
      });

      if (!fieldCriteriaMap.containsKey(criteria.getField())) {
        MongoDocument mapDocument = new MongoDocument();
        if(criteria.getOperator() != null) {
          matchDocument.append(criteria.getField(), mapDocument.append(criteria.getOperator(), criteria.getValue()));
        } else {
          matchDocument.append(criteria.getField(), criteria.getValue());
        }
        fieldCriteriaMap.put(criteria.getField(), mapDocument);
      }
    });

    matchStage = new MongoDocument(StatsSourceConstants.OperatorContstants.MATCH, matchDocument);
  }


  public MongoDocument build() {
    return matchStage;
  }

}
