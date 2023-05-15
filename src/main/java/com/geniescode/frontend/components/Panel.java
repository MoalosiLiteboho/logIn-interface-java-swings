package com.geniescode.frontend.components;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class Panel extends JPanel {
    private int cornerCurve;
    private String constraints = "";

    public Panel() {
        setOpaque(false);
    }

    private Shape topRight() {
        Area area = getArea();
        area.add(new Area(new Rectangle2D.Double(0, 0, getWidth() - cornerCurve, getHeight())));
        area.add(new Area(new Rectangle2D.Double(0, cornerCurve, getWidth(), getHeight() - cornerCurve )));
        return area;
    }

    private Shape topLeft() {
        Area area = getArea();
        area.add(new Area(new Rectangle2D.Double(cornerCurve, 0, getWidth() - cornerCurve, getHeight())));
        area.add(new Area(new Rectangle2D.Double(0, cornerCurve, getWidth(), getHeight() - cornerCurve )));
        return area;
    }

    private Shape bottomRight() {
        Area area = getArea();
        area.add(new Area(new Rectangle2D.Double(0, 0, getWidth() - cornerCurve, getHeight())));
        area.add(new Area(new Rectangle2D.Double(0, 0, getWidth(), getHeight() - cornerCurve)));
        return area;
    }

    private Shape bottomLeft() {
        Area area = getArea();
        area.add(new Area(new Rectangle2D.Double(cornerCurve, 0, getWidth() - cornerCurve, getHeight())));
        area.add(new Area(new Rectangle2D.Double(0, 0, getWidth(), getHeight() - cornerCurve)));
        return area;
    }

    private Area getArea() {
        return new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerCurve, cornerCurve));
    }

    public void setConstraints(int number, String constraints) {
        this.cornerCurve = number;
        this.constraints = constraints;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics.create();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(getBackground());
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 0, 0));

        if (!constraints.isEmpty())
            if (constraints.equals("all"))
                area = getArea();
            else {
                if (constraints.contains("top right")) area.intersect(new Area(topRight()));
                if (constraints.contains("top left")) area.intersect(new Area(topLeft()));
                if (constraints.contains("bottom right")) area.intersect(new Area(bottomRight()));
                if (constraints.contains("bottom left")) area.intersect(new Area(bottomLeft()));
            }
        graphics2D.fill(area);
        graphics2D.dispose();
        super.paintComponent(graphics);
    }
}
