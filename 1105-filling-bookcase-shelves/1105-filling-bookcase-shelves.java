class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    private int helper(int idx, int[][] books, int shelfWidth){

        if(idx == books.length){
            return 0;
        }
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }

        int currWidth = shelfWidth;
        int maxHeight = 0;
        int res = Integer.MAX_VALUE;
        for(int j=idx;j<books.length;j++){
            int width = books[j][0];
            int height = books[j][1];
            if(currWidth < width){
                break;
            }
            currWidth -= width;
            maxHeight = Math.max(maxHeight, height);
            res = Math.min(res, helper(j+1, books, shelfWidth) + maxHeight);
        }
        memo.put(idx, res);
        return res;
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        if(shelfWidth <= 0){
            return 0;
        }
        return helper(0, books, shelfWidth);
    }
}