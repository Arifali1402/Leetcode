class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int size = (n*(n+1))/2;
        int newArr[] = new int[size];
        int k=0;
        for(int i=0;i<n;i++){
            int sum = nums[i];
            newArr[k++] = sum;
            for(int j=i+1;j<n;j++){
                sum += nums[j];
                newArr[k++] = sum;
            }
        }
        Arrays.sort(newArr);
        long ans = 0;
        while(left <= right){
            ans = (ans + newArr[left-1]);
            left++;
        }
        return (int)(ans%(1e9+7));
    }
}