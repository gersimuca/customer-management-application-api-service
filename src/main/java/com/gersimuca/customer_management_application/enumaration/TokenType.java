package com.gersimuca.customer_management_application.enumaration;

public enum TokenType {
    JWT("JSON Web Token"),
    OAUTH("OAuth Token"),
    SAML("SAML Token"),
    API_KEY("API Key"),
    SESSION("Session Token"),
    BEARER("Bearer Token");

    private final String description;

    TokenType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static TokenType fromString(String text) {
        for (TokenType type : TokenType.values()) {
            if (type.name().equalsIgnoreCase(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown token type: " + text);
    }

    @Override
    public String toString() {
        return description;
    }
}
