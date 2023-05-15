package com.geniescode.frontend;

import com.geniescode.frontend.components.Button;
import com.geniescode.frontend.components.ClosingBar;
import com.geniescode.frontend.components.Panel;
import com.geniescode.frontend.components.PasswordField;
import com.geniescode.frontend.components.TextField;
import com.geniescode.backend.LogInController;
import net.miginfocom.swing.MigLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

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
        setSize(new Dimension(600, 320));
        setBackground(new Color(0xffffff, true));
        setLocationRelativeTo(null);
        addController(this);
    }

    private void addController(LogInFrame logInFrame) {
        new LogInController(logInFrame);
    }

    public void addButtonListener(LogInController controller) {
        signIn.addActionListener(controller);
    }

    public Button getSignIn() {
        return signIn;
    }

    public String getUsername() {
        return username.toString();
    }

    public String getPassword() {
        return String.valueOf(
                password.getPassword()
        );
    }
}
