package com.geniescode.backend.logIn;

import com.geniescode.backend.getAllCredentials.GetAllCredentials;
import com.geniescode.backend.passwordEncryption.PasswordEncryption;

import javax.swing.JOptionPane;
import java.util.function.Consumer;

public class LogInService {
    private LogIn credentials;
    public void logInProcess(LogIn credentials) {
        this.credentials = credentials;
        String result = LogInValidation.isUsernameEmpty
                .and(LogInValidation.isPasswordEmpty)
                .apply(credentials);
        checkCredentialsAreNotEmpty(result, displayMessage);
    }

    private void checkCredentialsAreNotEmpty(String result, Consumer<String> showUserError) {
        if(!"SUCCESS".equals(result)) showUserError.accept(result);
        else tryToLogIn();
    }

    private void tryToLogIn() {
        if (areCredentialsValid())
            displayMessage.accept("User LogIn SUCCESSFULLY \nUser credentials are valid.");
        else
            displayMessage.accept("User credentials entered are not valid.");
    }

    private final Consumer<String> displayMessage = message
            -> JOptionPane.showMessageDialog(null, message);

    private boolean areCredentialsValid() {
        String hashedPassword = new PasswordEncryption().apply(credentials.password());
        return new  GetAllCredentials().get()
                .stream()
                .anyMatch(logIn -> logIn.username().equals(credentials.username()) && logIn.password().equals(hashedPassword));
    }
}
