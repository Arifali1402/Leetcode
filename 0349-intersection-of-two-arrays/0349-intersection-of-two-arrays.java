class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int elements: nums1){
            set.add(elements);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int elements: nums2){
            if(set.contains(elements)){
                list.add(elements);
                set.remove(elements);
            }
        }
        int array[] = new int[list.size()];
        int i=0;
        for(int elements: list){
            array[i++] = elements;
        }
        return array;
    }
    
}