class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int element: nums){
            map.put(element, map.getOrDefault(element, 0)+1);
        }
        int maxFreq = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            maxFreq = Math.max(maxFreq, entry.getValue());
        }
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(maxFreq == entry.getValue()){
                ans += entry.getValue();
            }
        }
        return ans;
    }
}