package org.mongine.criteria;

public class BaseCriteria<T extends Object>{

  public String field;
  public T value;
  private String operator;

  public BaseCriteria() {}

  public BaseCriteria(String field, T value) {
    this.field = field;
    this.value = value;
  }

  public BaseCriteria(String field, String operator, T value) {
    this.field = field;
    this.value = value;
    this.operator = operator;
  }

  public String getField() {
    return field;
  }

  public T getValue() {
    return value;
  }

  public String getOperator() {
    return operator;
  }

}
