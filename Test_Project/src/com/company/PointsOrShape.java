package com.company;

abstract class PointsOrShape {
    double x, y;

    PointsOrShape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    abstract void area();
}
