class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '1'){
                count++;
            }
        }
        String ans = "";
        for(int i=0;i<count-1;i++){
            ans+='1';
        }
        for(int i=0;i<s.length()-count;i++){
            ans+='0';
        }
        return ans+'1';
    }
}