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

// WRITEUP:
// We track which player (0 or 1) scores each element using a toggle bit `a`.
// We flip `a` whenever an odd number is encountered, and also flip it at every
// 6th index to represent group boundaries.
// We accumulate each element into p0 or p1 based on `a`, then return p0 - p1 as
// the score difference.
