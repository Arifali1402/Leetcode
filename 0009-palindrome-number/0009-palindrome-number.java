class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int temp1 = x;
        int temp2 = 0;
        while(x>0){
            int rem = x%10;
            temp2 = temp2*10 + rem;
            x = x/10;
        }
        if(temp2 == temp1){
            return true;
        }
        return false;
    }
}