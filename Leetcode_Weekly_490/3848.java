class Solution {
    public boolean isDigitorialPermutation(int n) {
        int[] f = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };
        int[] c1 = new int[10];
        int t = n;
        while (t > 0) {
            c1[t % 10]++;
            t /= 10;
        }
        int s = 0;
        t = n;
        while (t > 0) {
            s += f[t % 10];
            t /= 10;
        }
        int[] c2 = new int[10];
        t = s;
        while (t > 0) {
            c2[t % 10]++;
            t /= 10;
        }
        for (int i = 0; i < 10; i++)
            if (c1[i] != c2[i])
                return false;
        return true;
    }
}

// WRITEUP:
// We count the digit frequencies of n into array c1, then compute the
// digitorial s as the sum of the factorial of each digit of n.
// We then count the digit frequencies of s into array c2.
// n is a digitorial permutation if c1 and c2 match for every digit 0 through 9.
