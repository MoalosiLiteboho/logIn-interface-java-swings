package com.geniescode.logIn;

import java.util.function.Function;


public interface LogInValidation extends Function<UserCredentials, ValidationResults> {
    LogInValidation isUsernameEmpty = user -> !user.username().isEmpty() ?
            ValidationResults.SUCCESS : ValidationResults.USERNAME_EMPTY;

    LogInValidation isPasswordEmpty = user ->  !user.password().isEmpty() ?
            ValidationResults.SUCCESS : ValidationResults.PASSWORD_EMPTY;

    default LogInValidation and (LogInValidation others) {
        return user -> {
            ValidationResults result = this.apply(user);
            return ValidationResults.SUCCESS.equals(result) ?
                    others.apply(user) : result;
        };
    }
}