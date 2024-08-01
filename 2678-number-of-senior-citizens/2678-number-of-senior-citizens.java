class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String str: details){
            int age = (str.charAt(11)-'0')*10+(str.charAt(12)-'0');
            if(age>60){
                count++;
            }
        }
        return count;
    }
}