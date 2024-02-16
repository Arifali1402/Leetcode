class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int element: arr){
            map.put(element,map.getOrDefault(element,0)+1);
        }
        List<Integer> list = new LinkedList<>(map.values());
        Collections.sort(list);
        int freq = list.size();
        for(int i=0;i<list.size();i++){
            int f = list.get(i);
            if(k>=f){
                k = k - f;
                freq--;
            }
            else{
                break;
            }
        }
        return freq;
    }
}