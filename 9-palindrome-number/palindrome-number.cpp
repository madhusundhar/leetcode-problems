class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0){
            return false;
        }
        long  reverse=0;
        int original=x;
        while(x>0){
            int digits=x%10;
            reverse=reverse*10+digits;
            x=x/10;
        }
        return original==reverse;
    }
};