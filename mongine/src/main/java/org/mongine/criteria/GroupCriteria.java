package org.mongine.criteria;

public class GroupCriteria<T extends Object> extends BaseCriteria {

  public GroupCriteria(String field, String operator, Object value) {
    super(field, operator, value);
  }

}
