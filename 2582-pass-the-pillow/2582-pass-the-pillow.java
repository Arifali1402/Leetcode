class Solution {
    public int passThePillow(int n, int time) {
        if(time < n){
            return time+1;
        }
        int cycle = time/(n-1);
        int dir = time%(n-1); // remainder
        if(cycle%2 == 0){
            return dir+1;
        }
        return n-dir; 

    }
}