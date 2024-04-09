class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;
        int[] ans = new int[2];
        while(low < high){
            int first = numbers[low];
            int last = numbers[high];
            if(first + last == target){
                ans[0] = low+1;
                ans[1] = high+1;
                break;
            }
            else if((first + last) < target){
                low++;
            }
            else{
                high--;
            }
        }
        return ans;
    }
}