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

// WRITEUP: Count 0s and 1s in t. Greedily assign bits of s to maximize XOR: if
// s[i]=='0', use a '1' from t if available (XOR gives 1), else use a '0'. If
// s[i]=='1', use a '0' from t if available (XOR gives 1), else use a '1'.
