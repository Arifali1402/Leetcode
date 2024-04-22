class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        int i = 0;
        while(i < chars.length){
            char curr = chars[i];
            int count = 0;
            while(i<chars.length && curr == chars[i]){
                count++;
                i++;
            }
            chars[idx++] = curr;
            if(count > 1){
                for(char c: Integer.toString(count).toCharArray()){
                    chars[idx++] = c;
                }
            }
        }
        return idx;
    }
}