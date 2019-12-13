package main;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Location extends Module {

    static Location selected;

    double x, y;
    double radius = 0;
    double speed = 1;
    double distance, distanceX, distanceY;
    Location target;
    double oldTargetX, oldTargetY;
    double xStep, yStep;
    double stepCount;
    boolean visible;

    @Override
    public void update() {
        super.update();
        moving();
        if (visible)  {
            Frame.frame.ig.drawOval((int) (x-radius),(int)(y-radius),(int)(radius*2),(int)(radius*2));
            if (isSelected()) Frame.frame.ig.drawRect((int) (x-radius),(int)(y-radius),(int)(radius*2),(int)(radius*2));
        }
    }

    @Override
    public void mousePressed() {
        super.mousePressed();
        if (visible) if (isUnderMouse()) {
            mousePressedThis();
        } else {
            if (Frame.mousePressed == 1) {
                selected = null;
            }
        }

        if (isSelected()) {
            if (Frame.mousePressed == 3) {
                target = new Location().setXY(Frame.mouseXY);
            }
        }
    }

    boolean isTouching(Location location) {
        if (getDistance(location) <= radius + location.radius + 1) {
            return true;
        }
        return false;
    }

    boolean isUnderMouse() {
        if (getDistance(Frame.mouseXY) <= radius) return true;
        return false;
    }

    public void mousePressedThis() {
        if (Frame.mousePressed == 1) {
            this.select();
        }
    }

    void select() {
        selected = this;
    }

    boolean isSelected() {
        if (selected == this) return true;
        return false;
    }

    public double getDistance(Point point) {
        distanceX = point.x - x;
        distanceY = point.y - y;
        distance = Math.sqrt(distanceX*distanceX+distanceY*distanceY);
        return distance;
    }

    public double getDistance(Location location) {
        distanceX = location.x - x;
        distanceY = location.y - y;
        distance = Math.sqrt(distanceX*distanceX+distanceY*distanceY);
        return distance;
    }

    private void moving() {
        if (target != null) if (oldTargetX != target.x || oldTargetY != target.y) {
            getDistance(target);
            stepCount = (int) (distance - target.radius - radius);
            xStep = distanceX/distance*speed;
            yStep = distanceY/distance*speed;

            oldTargetX = target.x;
            oldTargetY = target.y;
        }
        x += xStep;
        y += yStep;

        if (stepCount > 0) stepCount--;
        if (stepCount == 0) {
            xStep = 0;
            yStep = 0;
        }
    }

    ////////////////////////////////////////

    public Location setXY(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Location setXY(Point point) {
        this.x = point.x;
        this.y = point.y;
        return this;
    }

}
