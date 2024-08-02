class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int element: nums){
            map.put(element, map.getOrDefault(element, 0)+1);
        }
        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            if(m.getValue() > n/2){
                return m.getKey();
            }
        }
        return -1;
    }
}