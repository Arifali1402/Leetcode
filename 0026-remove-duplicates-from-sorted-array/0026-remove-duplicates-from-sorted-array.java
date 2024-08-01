class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        Iterator<Integer> iterator = set.iterator();
        int i=0;
        while (iterator.hasNext()) {
            nums[i++] = iterator.next();
        }
        return set.size();
    }
}