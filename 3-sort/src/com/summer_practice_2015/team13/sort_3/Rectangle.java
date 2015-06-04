package com.summer_practice_2015.team13.sort_3;

public class Rectangle extends Figure{
    int a, b;

    public double get_square() {
        return 1d * a * b;
    }

    public void print_square() {
        System.out.println("RECT " + get_square());
    }

    Rectangle(int _a, int _b) {
        a = _a;
        b = _b;
    }
}