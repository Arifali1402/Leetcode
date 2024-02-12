class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int element: nums){
            map.put(element,map.getOrDefault(element,0)+1);
        }
        for(Map.Entry<Integer,Integer> m: map.entrySet()){
            int freq = m.getValue();
            if(freq > n/2){
                return m.getKey();
            }
        }
        return -1;
    }
}