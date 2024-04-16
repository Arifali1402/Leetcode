class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int maxi = Arrays.stream(candies).max().getAsInt();
        for(int i=0;i<candies.length;i++){
            if(candies[i] + extraCandies >= maxi){
                ans.add(i,true);
            }
            else{
                ans.add(i,false);
            }
        }
        return ans;
    }
}