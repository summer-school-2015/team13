import java.io.*;
import java.util.*;

public class Main {

    static Scanner in;
    static PrintWriter out;

    static int parse (String s){
        int count = 1;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int input = 0;
        if (args.length == 0){
            in = new Scanner(System.in);
            out = new PrintWriter(System.out);
        }
        else{
            if (args.length == 1){
                if (args[0].charAt(0) == 'i') {
                    in = new Scanner(new File(args[0].substring(3)));
                    out = new PrintWriter(System.out);
                    input = 1;
                }
                else{
                    in = new Scanner(System.in);
                    out = new PrintWriter(new File(args[0].substring(3)));
                }
            }
            else{
                input = 1;
                if (args[0].charAt(0) == 'i') {
                    in = new Scanner(new File(args[0].substring(3)));
                    out = new PrintWriter(args[1].substring(3));
                }
                else{
                    in = new Scanner(args[1].substring(3));
                    out = new PrintWriter(new File(args[0].substring(3)));
                }
            }
        }
        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;
        out.println("number of Lines, nuimber of words, number of symbols");
        if (input == 1){
            while (in.hasNext()){
                ans1++;
                String s = in.nextLine();
                ans2 += parse(s);
                ans3 += s.length();
            }
        }
        else {
            String s = "";
            while (!(s.length() == 1 && s.charAt(0) == '.')) {
                ans1++;
                s = in.nextLine();
                ans2 += parse(s);
                ans3 += s.length();
            }
            ans1 -= 1;
            ans2 -= 1;
            ans3 -= 1;
        }
        out.println((ans1) + " " + (ans2) + " " + (ans3));
        out.close();
    }
}
