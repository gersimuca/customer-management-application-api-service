package com.gersimuca.cma.feature.shared;

import jakarta.persistence.Embeddable;

@Embeddable
public class Image {
    private String id;
    private String name;
    private String path;
    private String description;
    private boolean isPublic = false;
}
