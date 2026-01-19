class Solution {
    public String mergeAlternately(String w1, String w2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < w1.length() || i < w2.length()) {
            if (i < w1.length()) sb.append(w1.charAt(i));
            if (i < w2.length()) sb.append(w2.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
