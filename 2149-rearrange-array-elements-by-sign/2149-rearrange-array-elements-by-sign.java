class Solution {
    public int[] rearrangeArray(int[] nums) {
        int ans[] = new int[nums.length];
        int pos[] = new int[nums.length/2];
        int neg[] = new int[nums.length/2];
        int i=0,j=0;
        for(int element: nums){
            if(element<0){
                neg[i++] = element;
            }
            else{
                pos[j++] = element;
            }
        }
        i = 0;
        j = 0;
        int p = 0;
        for(int k = 0;k<nums.length/2;k++){
            ans[p++] = pos[i++];
            ans[p++] = neg[j++];
        }
        return ans;
    }
}