class Solution {
    public String customSortString(String order, String s) {
        StringBuilder ans = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(char c: order.toCharArray()){
            if(map.get(c) != null){
                int freq = map.get(c);
                while(freq > 0){
                    ans.append(c);
                    freq--;
                }
                map.remove(c);
            }
        }
        for(Map.Entry<Character,Integer> cust: map.entrySet()){
            if(cust.getValue() != null){
                int freq = cust.getValue();
                while(freq > 0){
                    ans.append(cust.getKey());
                    freq--;
                }
            }
        }
        return ans.toString();
    }
}