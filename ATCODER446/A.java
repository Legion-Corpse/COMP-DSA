package ATCODER446;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String r = "Of" + Character.toLowerCase(s.charAt(0)) + s.substring(1);
        System.out.println(r);
    }
}

// WRITEUP: Prepend "Of" to the input string, lowercasing its first character to
// follow the "Of + word" naming pattern.
