package com.summer_practice_2015.team13.counter_1;

import java.io.*;
import java.util.*;

public class Main {

    static Scanner in;
    static PrintWriter out;

    static int parse(String str) {
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }

        if (str.length() == 0) {
            return 0;
        }

        return count;
    }

    public static void main(String[] args) throws  FileNotFoundException{
        boolean input_file = false;
        boolean output_file = false;

        in = new Scanner(System.in);
        out = new PrintWriter(System.out);

        for (int i = 0; i < args.length; i++) {
            if (args[i].charAt(0) == 'i') {
                try {
                    in = new Scanner(new File(args[i].substring(3)));
                } catch (FileNotFoundException e) {
                    System.out.println("Input file not found!");
                }
                input_file = true;
            }
            if (args[i].charAt(0) == 'o') {
                out = new PrintWriter(new File(args[i].substring(3)));
                output_file = true;
            }
        }

        if (!input_file && !output_file) {
            out.println("Must have new dot line in the end!");
            out.println("Input:");
            out.flush();
        }

        int lines_number = 0;
        int words_number = 0;
        int symbols_number = 0;

        String temp_str = "";

        while ((input_file && in.hasNext()) || (!input_file && (!(temp_str.length() == 1 && temp_str.charAt(0) == '.')))) {
            lines_number++;
            temp_str = in.nextLine();
            words_number += parse(temp_str);
            symbols_number += temp_str.length();
        }
        if (!input_file) {
            lines_number--;
            words_number--;
            symbols_number--;
        }

        if (!input_file && !output_file) {
            out.println();
            out.println("Output:");
        }

        out.println("Number of Lines: " + (lines_number));
        out.println("Number of words: " + (words_number));
        out.println("Number of symbols: " + (symbols_number));
        out.close();
    }
}
