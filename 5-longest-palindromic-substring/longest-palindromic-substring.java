class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), start = 0, len = 1;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i + l - 1 < n; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && (l == 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (l > len) {
                        start = i;
                        len = l;
                    }
                }
            }
        }
        return s.substring(start, start + len);
    }
}
