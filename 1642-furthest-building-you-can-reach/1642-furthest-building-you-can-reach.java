class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = heights.length;
        for(int i=1;i<n;i++){
            int difference = heights[i] - heights[i-1];
            if(difference > 0){
                // Inside the Priority queue.
                if(queue.size()<ladders){
                    queue.offer(difference);
                }
                else{
                    // Try to optimize it
                    int br = difference;
                    // If P queue contains a value less than difference
                    if(queue.size() > 0 && queue.peek() < difference){
                        // Update brick
                        br = queue.remove();
                        // add highest height to P queue
                        queue.offer(difference);
                    }
                    // Using bricks
                    if(bricks - br >=0){
                        bricks = bricks - br;
                    }
                    // returning the furthest building we can reach
                    else{
                        return i-1;
                    }
                }
            }
        }
        return heights.length - 1;
    }
}