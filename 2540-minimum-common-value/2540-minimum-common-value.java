class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
       Map<Integer, Integer> map = new HashMap<>();
        for(int element: nums1){
            map.put(element, map.getOrDefault(element, 0)+1);
        }
        Arrays.sort(nums2);
        for(int element: nums2){
            if(map.get(element) != null){
                return element;
            }
        }
        return -1;
    }
}