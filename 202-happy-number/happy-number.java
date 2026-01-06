class Solution {
    public boolean isHappy(int n) {
        int temp=n;
        while(temp!=1 && temp!=4){
            int sum=0;
            int sqr=0;
            while(temp!=0){
                int rem=temp%10;
                    sqr=rem*rem;
                    sum+=sqr;
                    temp/=10;
        }
            temp=sum;
        }
    if(temp==1){
        return true;
    }
    return false;
    }
}