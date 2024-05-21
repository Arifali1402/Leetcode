class Solution {
    
    private void findSubsets(int n, int[] nums, List<List<Integer>> list, List<Integer> l)
    {
        if(n == 0){
            list.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[n-1]);
        findSubsets(n-1,nums,list,l);
        l.remove(l.size()-1);
        findSubsets(n-1,nums,list,l);
    }    
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        findSubsets(n,nums,list,new ArrayList<>());
        return list;
    }
}