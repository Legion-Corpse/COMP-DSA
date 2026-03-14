class Solution {
    public int scoreDifference(int[] nums) {
        int a = 0;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1)
                a = 1 - a;
            if (i % 6 == 5)
                a = 1 - a;
            if (a == 0)
                p0 += nums[i];
            else
                p1 += nums[i];
        }
        return p0 - p1;
    }
}

// WRITEUP: Track which player scores each element using a toggle bit `a`. Flip
// `a` on every odd number encountered and every 6th index. Accumulate p0 and p1
// accordingly and return p0 - p1.
