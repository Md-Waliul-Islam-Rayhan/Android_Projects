package com.company;

public class Circle extends PointsOrShape{
    double r;

    Circle(double x, double y, double r) {
        super(x, y);
        this.r = r;
    }
        @Override
        void area(){
            System.out.println(3.1416*r*r);
        }
}
