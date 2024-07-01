class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for(int element: arr){
            if(element%2 != 0){
                count++;
                if(count == 3){
                    return true;
                }
            }
            else{
                count = 0;
            }
        }
        return false;
    }
}