class Solution {
    public int reverse(int x) {
        long temp = 0;
        int sign = x;
        if(x<0){
            x = x*-1;
        }
        while(x > 0){
            int rem = x%10;
            temp = temp*10 + rem;
            x = x/10;
        }
        if(temp >= Integer.MIN_VALUE && temp <= Integer.MAX_VALUE){
            return sign < 0? -(int)temp:(int)temp;
        }
        else{
            return 0;
        }
    }
}