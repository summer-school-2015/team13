package com.summer_practice_2015.team13.sortex_3;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws  FileNotFoundException{
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        boolean flag = false;
        int n = 0;
        try{
            n = in.nextInt();
        }
        catch(InputMismatchException e){
            out.println("Input error");
            out.println();
            out.flush();
            flag = true;
        }
        Figure figures[] = new Figure[n];
        TreeSet<Figure> f = new TreeSet<Figure>();
        ArrayList<Figure> f1 = new ArrayList<Figure>();
        if (!flag) {
            for (int i = 0; i < n; i++) {
                String s = in.next();
                try {
                    if (s.charAt(0) == 'C') {
                        int r = in.nextInt();
                        figures[i] = new Circle(r);
                    }
                    if (s.charAt(0) == 'T') {
                        int a = in.nextInt();
                        int h = in.nextInt();
                        figures[i] = new Triangle(a, h);
                    }
                    if (s.charAt(0) == 'R') {
                        int a = in.nextInt();
                        int b = in.nextInt();
                        figures[i] = new Rectangle(a, b);
                    }
                    f.add(figures[i]);
                    f1.add(figures[i]);
                } catch (InputMismatchException e) {
                    out.println("Input error");
                    out.println();
                    out.flush();
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) {
            Arrays.sort(figures);
            f1.sort(Comparator.<Figure>naturalOrder());
        /*
        for (int i = 0; i < n; i++) {
            figures[i].print_square();
        }*/
        /*
        while (f.size() > 0){
            f.pollFirst().print_square();
        }*/
            for (Figure q : f1) {
                q.print_square();
            }
        }
        out.close();
    }
}
