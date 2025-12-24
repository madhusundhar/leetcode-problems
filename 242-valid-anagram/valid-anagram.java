class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        String ch=new String(a);
        String ch1=new String(b);

        if(ch.equals(ch1)){
            return true;
        }
            else
        return false;
    }
}