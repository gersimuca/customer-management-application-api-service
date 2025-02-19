package com.gersimuca.cma.unreleased.shared;

import jakarta.persistence.Embeddable;

@Embeddable
public class CustomField {
  private String fieldName;
  private String fieldType = "string";
  private String fieldValue;
}
