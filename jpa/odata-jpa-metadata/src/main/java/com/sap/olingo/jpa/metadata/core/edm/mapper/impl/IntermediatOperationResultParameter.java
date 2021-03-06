package com.sap.olingo.jpa.metadata.core.edm.mapper.impl;

import org.apache.olingo.commons.api.edm.FullQualifiedName;
import org.apache.olingo.commons.api.edm.geo.SRID;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction.ReturnType;
import com.sap.olingo.jpa.metadata.core.edm.mapper.api.JPAOperation;
import com.sap.olingo.jpa.metadata.core.edm.mapper.api.JPAOperationResultParameter;

class IntermediatOperationResultParameter implements JPAOperationResultParameter {
  /**
   * 
   */
  private final JPAOperation jpaOperation;
  private final ReturnType jpaReturnType;
  private final Class<?> type;
  private final boolean isCollection;

  public IntermediatOperationResultParameter(JPAOperation jpaOperation, final ReturnType jpaReturnType) {
    this.jpaOperation = jpaOperation;
    this.jpaReturnType = jpaReturnType;
    this.type = jpaReturnType.type();
    this.isCollection = jpaReturnType.isCollection();
  }

  public IntermediatOperationResultParameter(JPAOperation jpaOperation, ReturnType jpaReturnType, Class<?> returnType,
      boolean isCollection) {
    this.jpaOperation = jpaOperation;
    this.jpaReturnType = jpaReturnType;
    this.isCollection = isCollection;
    if (isCollection)
      this.type = jpaReturnType.type();
    else
      this.type = returnType;
  }

  @Override
  public Class<?> getType() {
    return type;
  }

  @Override
  public Integer getMaxLength() {
    return jpaReturnType.maxLength();
  }

  @Override
  public Integer getPrecision() {
    return jpaReturnType.precision();
  }

  @Override
  public Integer getScale() {
    return jpaReturnType.scale();
  }

  @Override
  public FullQualifiedName getTypeFQN() {
    return jpaOperation.getReturnType().getTypeFQN();
  }

  @Override
  public boolean isCollection() {
    return isCollection;
  }

  @Override
  public SRID getSrid() {
    // TODO Auto-generated method stub
    return null;
  }

}