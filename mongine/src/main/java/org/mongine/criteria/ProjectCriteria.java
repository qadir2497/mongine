package org.mongine.criteria;

public class ProjectCriteria <T extends Object> extends BaseCriteria {

  public ProjectCriteria(String field, String operator, Object value) {
    super(field, operator, value);
  }
}
