class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        // int freq[] = new int[26];
        // for(char ch: tasks){
        //     freq[ch - 'A']++;
        // }
        // int max = Integer.MIN_VALUE;
        // for(int element: freq){
        //     max = Math.max(max, element);
        // }
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: tasks){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int freq = 0;
        int maxi = Integer.MIN_VALUE;
        for(Map.Entry<Character, Integer> m : map.entrySet()){
            if(m.getValue() > maxi){
                maxi = m.getValue();
            }
        }
        for(Map.Entry<Character, Integer> m : map.entrySet()){
            if(maxi == m.getValue()){
                freq++;
            }
        }
        return Math.max((n+1)*(maxi-1) + freq,len);
    }
}