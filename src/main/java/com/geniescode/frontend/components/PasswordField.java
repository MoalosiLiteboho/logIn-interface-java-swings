package com.geniescode.frontend.components;

import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import static java.awt.Color.gray;
import static java.awt.Color.green;

public class PasswordField extends JPasswordField {
    private final String labelName;

    private boolean focused;
    private Color bottomLine = green;

    public PasswordField(String labelName) {
        this.labelName = labelName;
        initComponents();
    }

    private void initComponents() {
        setBorder(new EmptyBorder(20, 3, 10, 3));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                focused = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                focused = !String.valueOf(getPassword()).isEmpty();
                repaint();
            }
        });
    }

    private void createLabel(Graphics2D graphics2D) {
        Insets insets = getInsets();
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        Rectangle2D rectangle2D = fontMetrics.getStringBounds(labelName, graphics2D);
        double height = getHeight() - insets.top - insets.bottom;
        double textY = (height - rectangle2D.getHeight()) / 2;
        graphics2D.setColor(gray);

        if (focused) graphics2D.drawString(labelName, insets.right, (int) (insets.top + textY + fontMetrics.getAscent() - 18));
        else graphics2D.drawString(labelName, insets.right, (int) (insets.bottom + textY + fontMetrics.getAscent() + 10));
    }

    public void setBottomLine(Color bottomLine) {
        this.bottomLine = bottomLine;
        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        graphics2D.setColor(bottomLine);
        graphics2D.fillRect(2, getHeight() - 2, getWidth() - 4, 3);
        createLabel(graphics2D);
        graphics2D.dispose();
    }
}
