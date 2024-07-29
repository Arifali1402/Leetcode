class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        for(int m=1;m<n-1;m++){
            //For ascending order
            int leftSmaller = 0;
            int rightGreater = 0;
            for(int i=0;i<m;i++){
                if(rating[i] < rating[m]){
                    leftSmaller++;
                }
            }
            for(int i=m+1;i<n;i++){
                if(rating[m] < rating[i]){
                    rightGreater++;
                }
            }
            count += (leftSmaller * rightGreater);

            // For descending order
            int leftGreater = m-leftSmaller;
            int rightSmaller = n-m-1-rightGreater;
            count += (leftGreater * rightSmaller);
        }
        return count;
    }
}