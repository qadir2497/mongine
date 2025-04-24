package org.mongine.criteria;

public class MatchCriteria <T extends Object> extends BaseCriteria {

  public MatchCriteria(String field, String operator, Object value) {
    super(field, operator, value);
  }

  public MatchCriteria(String field, Object value) {
    super(field, value);
  }

}


