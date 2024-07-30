class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        // count the number of 'a' at the right side of each element
        int countA[] = new int[n];
        // Number of 'a' at the right of the element situated at index 'n-1' is always 0
        countA[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            if(s.charAt(i+1) == 'a'){
                countA[i] = countA[i+1] + 1;
            }
            else{
                countA[i] = countA[i+1];
            }
        }
        // for(int i=0;i<n;i++){
        //     System.out.print(countA[i]+" ");
        // }

        // count the number of 'b' at the left side of each element
        int countB[] = new int[n];
        // Number of 'b' at the left of the element situated at index '0' is always 0
        countB[0] = 0;
        for(int i=1;i<n;i++){
            if(s.charAt(i-1) == 'b'){
                countB[i] = countB[i-1] + 1;
            }
            else{
                countB[i] = countB[i-1];
            }
        }
        // System.out.println();
        // for(int i=0;i<n;i++){
        //     System.out.print(countB[i]+" ");
        // }
        // for(int i=0;i<n;i++){
        //     System.out.print(countB[i]+countA[i]);
        // }

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.min(ans, countA[i]+countB[i]);
        }
        return ans;
    }
}
/*
class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int count = Integer.MAX_VALUE;
        for(int m=0;m<n;m++){
            // Remove all 'b' from left side
            int left = 0;
            for(int i=0;i<m;i++){
                if(s.charAt(i) == 'b'){
                    left++;
                }
            }
            // Remove all 'a' from right side
            int right = 0;
            for(int i=m+1;i<n;i++){
                if(s.charAt(i) == 'a'){
                    right++;
                }
            }
            count = Math.min(count, left+right);
        }
        return count;
    }
}
*/