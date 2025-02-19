package com.gersimuca.cma.unreleased.shared;

import jakarta.persistence.Embeddable;

@Embeddable
public class File {
  private String id;
  private String name;
  private String path;
  private String description;
  private boolean isPublic = false;
}
