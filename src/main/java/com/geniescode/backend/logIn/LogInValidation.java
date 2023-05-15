package com.geniescode.backend.logIn;

import java.util.function.Function;

import static com.geniescode.backend.logIn.ValidationResults.PASSWORD_EMPTY;
import static com.geniescode.backend.logIn.ValidationResults.SUCCESS;
import static com.geniescode.backend.logIn.ValidationResults.USERNAME_EMPTY;


public interface LogInValidation extends Function<LogIn, String> {
    LogInValidation isUsernameEmpty = user -> !user.username().isEmpty() ?
            SUCCESS.getValue() : USERNAME_EMPTY.getValue();

    LogInValidation isPasswordEmpty = user ->  !user.password().isEmpty() ?
            SUCCESS.getValue() : PASSWORD_EMPTY.getValue();

    default LogInValidation and (LogInValidation others) {
        return user -> {
            String result = this.apply(user);
            return SUCCESS.getValue().equals(result) ?
                    others.apply(user) : result;
        };
    }
}