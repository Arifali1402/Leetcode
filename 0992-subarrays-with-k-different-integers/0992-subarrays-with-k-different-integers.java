class Solution {
    // Sliding Window with 3 Pointers.
    public int subarraysWithKDistinct(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int leftNear = 0;
        int leftFar = 0;
        for(int right = 0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            
            while(map.size() > k){
                map.put(nums[leftNear], map.get(nums[leftNear])-1);
                if(map.get(nums[leftNear]) == 0){
                    map.remove(nums[leftNear]);
                }
                leftNear++;
                leftFar = leftNear;
            }
            
            while(map.get(nums[leftNear]) > 1){
                map.put(nums[leftNear],map.get(nums[leftNear])-1);
                leftNear++;
            }
            
            if(map.size() == k){
                ans += leftNear - leftFar + 1;
            }
        }
        return ans;
    }
}