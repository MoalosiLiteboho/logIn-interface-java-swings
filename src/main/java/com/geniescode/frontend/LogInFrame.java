package com.geniescode.frontend;

import com.geniescode.backend.logIn.LogInController;
import com.geniescode.frontend.components.Button;
import com.geniescode.frontend.components.ClosingBar;
import com.geniescode.frontend.components.Panel;
import com.geniescode.frontend.components.PasswordField;
import com.geniescode.frontend.components.TextField;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.green;
import static java.awt.Color.white;

public class LogInFrame extends JFrame {
    private TextField username;
    private PasswordField password;
    private Button signIn;

    public LogInFrame() {
        initComponents();
    }

    private void initComponents() {
        Panel background = new Panel();
        ClosingBar closeButton = new ClosingBar();
        JLabel tittle = new JLabel();
        username = new TextField("Username:");
        password = new PasswordField("Password:");
        signIn = new Button();

        signIn.setText("LogIn");
        signIn.setConstraints(green, 40);
        signIn.setFont(signIn.getFont().deriveFont(Font.PLAIN, 18));

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
        background.add(password, "height 45px, width 60%, gap left 20%, gap bottom 25px");
        background.add(signIn, "width 30%, height 35px, gap left 35%");
        background.setConstraints(25, "all");
        background.setBackground(white);


        setLayout(new MigLayout("inset 0px, fill", "[fill]", "[fill]"));
        add(background);
        setUndecorated(true);
        setResizable(false);
        setFont(new Font("sanserif", Font.PLAIN, 16));
        setSize(new Dimension(570, 320));
        setBackground(new Color(0xffffff, true));
        setLocationRelativeTo(null);
        addController(this);
    }

    private void addController(LogInFrame frame) {
        new LogInController(frame);
    }


    public void addButtonListener(LogInController controller) {
        signIn.addActionListener(controller);
    }

    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return String.valueOf(password.getPassword());
    }

    public Button getSignIn() {
        return signIn;
    }
}
