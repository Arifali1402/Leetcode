class Solution {
    public String reverseWords(String s) {
        String str = s.replaceAll("\\s+"," ");
        String arr[] = str.trim().split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            ans.append(arr[i]);
            if(i != 0){
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}