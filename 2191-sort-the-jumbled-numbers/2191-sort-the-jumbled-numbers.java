class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // Map<Idx, mapping[Idx]> map = new HashMap<>();
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            map.put(i, mapping[i]);
        }
        int[] newValues = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            int newNum = 0;
            String numStr = Integer.toString(nums[i]);
            for(int j=0;j<numStr.length();j++){
                newNum = (newNum*10) + mapping[Character.getNumericValue(numStr.charAt(j))];
            }
            newValues[i] = newNum;
        }
        for (int i=0;i<nums.length;i++) {
            System.out.println(newValues[i]);
        }
        // Create a list of pairs (original number, mapped value)
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new int[]{nums[i], newValues[i]});
        }
        // Sort the list based on the mapped values
        Collections.sort(list, Comparator.comparingInt(a -> a[1]));
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = list.get(i)[0];
        }
        return ans;
    }
}