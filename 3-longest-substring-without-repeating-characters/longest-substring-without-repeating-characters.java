class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int l = 0, res = 0;
        for (int r = 0; r < s.length(); r++) {
            l = Math.max(l, map[s.charAt(r)]);
            res = Math.max(res, r - l + 1);
            map[s.charAt(r)] = r + 1;
        }
        return res;
    }
}
