package com.geniescode.frontend.components;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import static java.awt.Color.red;
import static java.awt.Cursor.HAND_CURSOR;

public class ClosingBar extends JComponent {
    public ClosingBar() {
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        ClosingButton closingButton = new ClosingButton();
        closingButton.addActionListener(action -> System.exit(0));

        panel.setLayout(new MigLayout("inset 3px"));
        panel.add(closingButton);
        panel.setOpaque(false);

        setLayout(new MigLayout("inset 3px, fill", "[fill]", "[fill]"));
        add(panel);
    }

    private final static class ClosingButton extends JButton {

        public ClosingButton() {
            initComponents();
        }

        private void initComponents() {
            setContentAreaFilled(false);
            setBorder(null);
            setPreferredSize(new Dimension(20, 20));
            setCursor(new Cursor(HAND_CURSOR));
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            Graphics2D graphics2D = (Graphics2D) graphics.create();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setColor(red);
            graphics2D.fillOval(0, 0, getWidth(), getHeight());
            graphics2D.dispose();
        }
    }
}
