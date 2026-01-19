class Solution {
    public String reverseVowels(String s) {
        Set<Character> v = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (!v.contains(arr[l])) l++;
            else if (!v.contains(arr[r])) r--;
            else {
                char t = arr[l];
                arr[l++] = arr[r];
                arr[r--] = t;
            }
        }
        return new String(arr);
    }
}
