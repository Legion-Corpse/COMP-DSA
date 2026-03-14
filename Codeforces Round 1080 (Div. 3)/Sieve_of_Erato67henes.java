import java.util.Scanner;

public class Sieve_of_Erato67henes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            boolean f = false;
            for (int i = 0; i < n; i++) {
                if (s.nextInt() == 67)
                    f = true;
            }
            System.out.println(f ? "YES" : "NO");
        }
    }
}

// WRITEUP: Simply scan each test case's array and check if 67 appears at least
// once. Output YES if found, NO otherwise.
