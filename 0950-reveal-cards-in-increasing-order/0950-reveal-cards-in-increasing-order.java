class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Deque<Integer> dq = new LinkedList<>();
        Arrays.sort(deck);
        dq.add(deck[n-1]);
        for(int i = n-2;i>=0;i--){
            dq.addFirst(dq.pollLast());
            dq.addFirst(deck[i]);
        }
        int ans[] = new int[n];
        int k = 0;
        while(!dq.isEmpty()){
            ans[k++] = dq.pollFirst();
        }
        return ans;
    }
}