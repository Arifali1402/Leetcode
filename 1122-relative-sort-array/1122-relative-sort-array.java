class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int ans[] = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr1);
        for(int element: arr1){
            map.put(element, map.getOrDefault(element, 0)+1);
        }
        int k=0;
        for(int i=0;i<arr2.length;i++){
            if(map.containsKey(arr2[i])){
                int len = map.get(arr2[i]);
                for(int j=0;j<len;j++){
                    ans[k++] = arr2[i];
                }
                map.remove(arr2[i]);
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(null);
        for(int key: list){
            int len = map.get(key);
            for(int p=0;p<len;p++){
                ans[k++] = key;
            }
        }
        return ans;
    }
}