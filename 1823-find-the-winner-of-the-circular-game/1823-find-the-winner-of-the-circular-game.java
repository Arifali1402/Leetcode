class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(i);
        }
        int j = 0;
        while(list.size() > 1){
            j = (j+k-1)%list.size();
            list.remove(j);
        }
        return list.get(0)+1;
    }
}