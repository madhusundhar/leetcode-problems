class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = indices.length;
        int[] match = new int[s.length()];
        Arrays.fill(match, -1);

        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            if (s.startsWith(sources[i], idx)) {
                match[idx] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            if (match[i] >= 0) {
                sb.append(targets[match[i]]);
                i += sources[match[i]].length();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}
