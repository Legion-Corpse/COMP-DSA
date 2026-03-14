class Solution {
    public String maximumXor(String s, String t) {
        int x = 0, y = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '0')
                x++;
            else
                y++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (y > 0) {
                    res.append('1');
                    y--;
                } else {
                    res.append('0');
                    x--;
                }
            } else {
                if (x > 0) {
                    res.append('1');
                    x--;
                } else {
                    res.append('0');
                    y--;
                }
            }
        }
        return res.toString();
    }
}

// WRITEUP:
// We count the 0s and 1s in t to know how many of each bit we have available to
// XOR with.
// We then greedily assign bits to maximize XOR: for each bit of s, we always
// try to pair it with the opposite bit from t to produce a 1.
// If s[i]=='0' we use a '1' from t if available, else a '0'. If s[i]=='1' we
// use a '0' from t if available, else a '1'.
