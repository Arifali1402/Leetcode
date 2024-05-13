class Solution {
    public int largestAltitude(int[] gain) {
        int maxHeight = 0;
        int curr = 0;
        for(int i=0;i<gain.length;i++){
            curr += gain[i];
            maxHeight = Math.max(maxHeight, curr);
        }
        return maxHeight;
    }
}