package com.geniescode.backend;

public enum ValidationResults {
    SUCCESS("SUCCESS"),
    USERNAME_EMPTY("Username is empty \nPlease fill username"),
    PASSWORD_EMPTY("Password is empty \nPlease fill password");

    private final String value;

    ValidationResults(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
