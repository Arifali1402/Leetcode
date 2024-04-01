class Solution {
    public int lengthOfLastWord(String s) {
        String str = s.trim();
        String arr[] = str.split(" ");
        int ans = 0;
        int len = arr.length;
        return arr[len-1].length();
    }
}