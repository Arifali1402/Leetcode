class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2){
            return nums;
        }
        int ans[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int element: nums){
            map.put(element, map.getOrDefault(element, 0)+1);
        }
        int count = 0;
        for(Map.Entry<Integer, Integer> m:map.entrySet()){
            if(m.getValue() == 1){
                if(count == 0){
                    ans[0] = m.getKey();
                    count++;
                }
                else{
                    ans[1] = m.getKey();
                }
            }
        }
        return ans;
    }
}