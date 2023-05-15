package com.geniescode.backend.logIn;

import com.geniescode.frontend.LogInFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInController implements ActionListener {
    private final LogInFrame logInFrame;

    public LogInController(LogInFrame logInFrame) {
        this.logInFrame = logInFrame;
        logInFrame.addButtonListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == logInFrame.getSignIn())
            logInProcess();
    }

    private void logInProcess() {
        new LogInService().logInProcess(
                new LogIn(logInFrame.getUsername(), logInFrame.getPassword())
        );
    }
}
