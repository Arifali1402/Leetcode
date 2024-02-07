class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        StringBuilder ans = new StringBuilder();
        List<Map.Entry<Character,Integer>> l1 = new LinkedList<>(map.entrySet());
        l1.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        for(Map.Entry<Character,Integer> m : l1){
            for(int i=0;i<m.getValue();i++){
                ans.append(m.getKey());
            }
        }
        return ans.toString();
    }
}