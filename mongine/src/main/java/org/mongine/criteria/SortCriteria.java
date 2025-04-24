package org.mongine.criteria;

public class SortCriteria <T extends Object> extends BaseCriteria {

  public SortCriteria(String field, String operator, Object value) {
    super(field, operator, value);
  }
}
