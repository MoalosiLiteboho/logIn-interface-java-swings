package com.geniescode.backend.passwordEncryption;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public class PasswordEncryption implements Function<String, String> {
    public String apply(String password) {
        return Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
    }
}
