package com.geniescode.backend;

import javax.swing.JOptionPane;
import java.util.function.Consumer;

public class LogInService {
    public void logInProcess(LogIn credentials) {
        String result = LogInValidation.isUsernameEmpty
                .and(LogInValidation.isPasswordEmpty)
                .apply(credentials);
        checkCredentials(result, displayError);
    }

    private void checkCredentials(String result, Consumer<String> showUserError) {
        if(!"SUCCESS".equals(result)) showUserError.accept(result);
        else System.out.println(result);
    }

    private final Consumer<String> displayError = error
            -> JOptionPane.showMessageDialog(null, error);
}
