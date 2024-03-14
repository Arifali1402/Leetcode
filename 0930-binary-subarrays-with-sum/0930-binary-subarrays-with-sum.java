class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int element : nums){
            prefixSum += element;
            result += map.getOrDefault(prefixSum - goal, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }
        return result;
    }
}