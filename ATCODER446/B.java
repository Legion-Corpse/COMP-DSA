package ATCODER446;

import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] taken = new boolean[m + 1];
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int chosen = 0;
            for (int j = 0; j < l; j++) {
                int x = sc.nextInt();
                if (chosen == 0 && !taken[x]) {
                    taken[x] = true;
                    chosen = x;
                }
            }
            System.out.println(chosen);
        }
    }
}

// WRITEUP: Greedily assign each person their first available (not yet taken)
// item from their preference list. Use a boolean array to mark taken items.
// Output the chosen item for each person (0 if none available).
