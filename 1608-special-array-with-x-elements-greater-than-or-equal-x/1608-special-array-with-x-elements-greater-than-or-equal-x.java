class Solution {
    public int specialArray(int[] nums) {
        int bucket[] = new int[1001];
        for(int element: nums){
            bucket[element]++;
        }
        int total = nums.length;
        for(int i=0;i<1001;i++){
            if(i == total){
                return i;
            }
            total -= bucket[i];
        }
        return -1;
    }
}