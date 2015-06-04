package com.summer_practice_2015.team13.sort_3;

public abstract class Figure implements IFigure, Comparable<Figure>{
    public int compareTo(Figure o){
        if (this.get_square() + 0.000001 < o.get_square()){
            return -1;
        }
        else{
            if (Math.abs(this.get_square() - o.get_square()) < 0.000001){
                return 0;
            }
            else{
                return 1;
            }
        }
    }
}
