class Solution {
    public String mostCommonWord(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        for (String w : p.toLowerCase().split("\\W+"))
            if (!ban.contains(w))
                map.put(w, map.getOrDefault(w, 0) + 1);
        String res = "";
        for (String k : map.keySet())
            if (res.equals("") || map.get(k) > map.get(res))
                res = k;
        return res;
    }
}
