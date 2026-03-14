package ATCODER446;

import java.io.*;
import java.util.*;

public class A {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static String next() throws IOException {
        while (!st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        String s = next();
        String r = "Of" + Character.toLowerCase(s.charAt(0)) + s.substring(1);
        pw.println(r);
        pw.flush();
    }
}

// WRITEUP:
// We lowercase the first character of the input word and prepend "Of" to it.
// This follows the "Of + word" naming convention required by the problem.
