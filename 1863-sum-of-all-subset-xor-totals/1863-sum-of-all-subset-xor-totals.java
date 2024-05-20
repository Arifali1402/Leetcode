class Solution {
    private void findSubsets(int n, int[] nums, List<Integer> sublist, List<List<Integer>> list){
        if(n == 0){
            list.add(new ArrayList<>(sublist));
            
            return;
        }
        sublist.add(nums[n-1]);
        findSubsets(n-1,nums,sublist, list);
        sublist.remove(sublist.size()-1);
        findSubsets(n-1, nums, sublist, list);
    }
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int xor = 0;
        if(nums.length == 0){
            return xor;
        }
        List<Integer> sublist = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        findSubsets(n, nums, sublist, list);
        for(List<Integer> l : list){
            int x = 0;
            for(int i=0;i<l.size();i++){
                x ^= l.get(i);
            }
            xor += x;
        }
        return xor;
    }
}