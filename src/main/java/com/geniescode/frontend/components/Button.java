package com.geniescode.frontend.components;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

import static java.awt.Color.white;
import static java.awt.Color.yellow;

public class Button extends JButton {
    private Integer round = 0;
    private Color buttonColor = yellow;
    public Button() {
        initComponents();
    }

    private void initComponents() {
        setContentAreaFilled(false);
        setBorder(null);
        setOpaque(false);
        setForeground(white);
        addMouseListener(null);
    }

    public void setConstraints(Color bottonColor, Integer round) {
        this.buttonColor = bottonColor;
        this.round = round;
        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics.create();
        graphics2D.setColor(Color.green);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), round, round));
        graphics2D.fill(area);
        graphics2D.dispose();
        super.paint(graphics);
    }
}
