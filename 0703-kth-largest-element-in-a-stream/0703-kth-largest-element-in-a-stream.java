class KthLargest {
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int element: nums){
            pq.add(element);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}

//  * Your KthLargest object will be instantiated and called as such:
//  * KthLargest obj = new KthLargest(k, nums);
//  * int param_1 = obj.add(val);

/**
class KthLargest {
    private List<Integer> list = new ArrayList<>();
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int element: nums){
            list.add(element);
        }
    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        int idx = list.size()-this.k;        
        return list.get(idx);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
