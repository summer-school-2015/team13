package com.summer_practice_2015.team13.sortex_3;

public class Circle extends Figure{
    int r;

    public double get_square() {
        return 1d * Math.PI * r * r;
    }

    public void print_square() {
        System.out.println("CIRCLE " + get_square());
    }

    Circle(int _r) {
        r = _r;
    }
}
