package com.summer_practice_2015.team13.sort_3;

public class Triangle extends Figure{
    int a, h;

    public double get_square() {
        return 1d * a * h / 2;
    }

    public void print_square() {
        System.out.println("TRIANGLE " + get_square());
    }

    Triangle(int _a, int _h) {
        a = _a;
        h = _h;
    }
}