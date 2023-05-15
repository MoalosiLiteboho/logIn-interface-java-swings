package com.geniescode.logIn;

import com.geniescode.components.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

import static com.geniescode.logIn.LogInValidation.isPasswordEmpty;
import static com.geniescode.logIn.LogInValidation.isUsernameEmpty;
import static com.geniescode.logIn.ValidationResults.SUCCESS;
import static java.awt.Color.green;
import static java.awt.Color.white;

public class LogIn extends JFrame {
    public LogIn() {
        initComponents();
    }

    private void initComponents() {
        Panel background = new Panel();
        ClosingBar closeButton = new ClosingBar();
        JLabel tittle = new JLabel();
        username = new TextField("Username:");
        password = new PasswordField("Password:");
        Button signIn = new Button();
        Button signUp = new Button();

        signUp.setText("Registration");
        signUp.setConstraints(green, 40);
        signUp.setFont(signUp.getFont().deriveFont(Font.PLAIN, 18));
        signUp.addActionListener(this::registrationAction);

        signIn.setText("LogIn");
        signIn.setConstraints(green, 40);
        signIn.setFont(signIn.getFont().deriveFont(Font.PLAIN, 18));
        signIn.addActionListener(this::logInAction);

        password.setBackground(white);

        username.setBackground(white);

        tittle.setText("LogIn");
        tittle.setHorizontalAlignment(SwingConstants.CENTER);
        tittle.setFont(tittle.getFont().deriveFont(Font.PLAIN, 25));
        tittle.setForeground(green);

        background.setLayout(new MigLayout("inset 0px, wrap"));
        background.add(closeButton, "width 100%");
        background.add(tittle, "width 100%, gap bottom 30px");
        background.add(username, "height 45px, width 60%, gap left 20%, gap bottom 5px");
        background.add(password, "height 45px, width 60%, gap left 20%, gap bottom 20px");
        background.add(signIn, "width 30%, height 35px, gap left 35%");
        background.add(signUp, "width 30%, height 35px, gap left 35%, gap top 5px");
        background.setConstraints(25, "all");
        background.setBackground(white);


        setLayout(new MigLayout("inset 0px, fill", "[fill]", "[fill]"));
        add(background);
        setUndecorated(true);
        setResizable(false);
        setFont(new Font("sanserif", Font.PLAIN, 16));
        setSize(new Dimension(600, 350));
        setBackground(new Color(0xffffff, true));
        setLocationRelativeTo(null);
    }

    private void logInAction(ActionEvent event) {
        logInProcess(new UserCredentials(username.getName(), String.valueOf(password.getPassword())));
    }

    public void logInProcess(UserCredentials user) {
        ValidationResults result = isUsernameEmpty
                .and(isPasswordEmpty)
                .apply(user);
        checkCredentials(result, displayError);
    }

    private void registrationAction(ActionEvent event) {
        //
        dispose();
    }

    private void checkCredentials(ValidationResults result, Consumer<ValidationResults> showUserError) {
        if(!SUCCESS.equals(result)) showUserError.accept(result);
        else System.out.println(result);
    }

    private final Consumer<ValidationResults> displayError = error -> JOptionPane.showMessageDialog(null, error);

    private TextField username;
    private PasswordField password;
}
