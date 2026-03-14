class Solution {

    public int countSequences(int[] nums, long k) {
        int[] kf = factorK(k);
        if (kf == null)
            return 0;

        int X2 = 38, X3 = 19, X5 = 19;
        int Y2 = 77, Y3 = 39, Y5 = 39;

        long[][][] dp = new long[Y2][Y3][Y5];
        dp[X2][X3][X5] = 1;

        for (int num : nums) {
            int[] nf = factorN(num);
            long[][][] ndp = new long[Y2][Y3][Y5];

            for (int a = 0; a < Y2; a++) {
                for (int b = 0; b < Y3; b++) {
                    for (int c = 0; c < Y5; c++) {
                        long v = dp[a][b][c];
                        if (v == 0)
                            continue;

                        ndp[a][b][c] += v;

                        int ma = a + nf[0], mb = b + nf[1], mc = c + nf[2];
                        if (ma < Y2 && mb < Y3 && mc < Y5)
                            ndp[ma][mb][mc] += v;

                        int da = a - nf[0], db = b - nf[1], dc = c - nf[2];
                        if (da >= 0 && db >= 0 && dc >= 0)
                            ndp[da][db][dc] += v;
                    }
                }
            }

            dp = ndp;
        }

        int ta = X2 + kf[0], tb = X3 + kf[1], tc = X5 + kf[2];
        if (ta < 0 || ta >= Y2 || tb < 0 || tb >= Y3 || tc < 0 || tc >= Y5)
            return 0;
        return (int) dp[ta][tb][tc];
    }

    int[] factorK(long n) {
        int[] r = new int[3];
        while (n % 2 == 0) {
            r[0]++;
            n /= 2;
        }
        while (n % 3 == 0) {
            r[1]++;
            n /= 3;
        }
        while (n % 5 == 0) {
            r[2]++;
            n /= 5;
        }
        return n == 1 ? r : null;
    }

    int[] factorN(int n) {
        int[] r = new int[3];
        while (n % 2 == 0) {
            r[0]++;
            n /= 2;
        }
        while (n % 3 == 0) {
            r[1]++;
            n /= 3;
        }
        while (n % 5 == 0) {
            r[2]++;
            n /= 5;
        }
        return r;
    }
}

// WRITEUP: k must be a product of only 2,3,5 (smooth number), else answer is 0.
// DP state tracks net exponents (2,3,5) of the running product relative to a
// centered offset. Each element can be included (+exponents), excluded (no
// change), or inverted (-exponents). At the end check if
// dp[offset+k2][offset+k3][offset+k5] matches the target exponents of k.
