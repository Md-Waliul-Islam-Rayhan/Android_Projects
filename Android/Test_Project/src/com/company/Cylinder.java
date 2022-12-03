package com.company;

public class Cylinder extends Circle{
    double h;

    Cylinder(double x, double y,  double r, double h){
        super(x,y,r);
        this.h = h;
    }

    @Override
    void area() {
        System.out.println(2*3.1416*r*r+h*2*3.1416*r);
    }
}
