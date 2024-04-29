class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for(int element: nums){
            xor = xor ^ element;
        }
        int count = 0;
        while(xor > 0 || k > 0){
            if(xor%2 != k%2){
                count++;
            }
            xor = xor/2;
            k = k/2;
        }
        return count;
    }
}