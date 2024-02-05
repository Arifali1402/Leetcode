class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<s.length();i++){
            Character ch = s.charAt(i);
            int total = map.get(ch);
            if(total == 1){
                return i;
            }
        }
        return -1;
    }
}