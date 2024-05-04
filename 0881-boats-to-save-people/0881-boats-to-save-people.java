class Solution {
    // TC = O(nlog(n))
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        if(n == 1 && limit >= people[0]){
            return 1;
        }
        if(n == 2){
            if(limit >= people[0] + people[1]){
                return 1;
            }
            else{
                return 2;
            }
        }

        Arrays.sort(people);
        int boats = 0;
        int left = 0;
        int right = n-1;
        while(left <= right){
            int remaining = limit - people[right];
            boats++;
            right--;
            if(left <= right && remaining >= people[left]){
                left++;
            }
        }
        return boats;
    }
}
/*
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        if(n == 1 && limit >= people[0]){
            return 1;
        }
        if(n == 2){
            if(limit >= people[0] + people[1]){
                return 1;
            }
            else{
                return 2;
            }
        }

        Arrays.sort(people);
        List<Integer> list = new ArrayList<>();

        for(int element : people){
            list.add(element);
        }

        int boats = 0;
        int i = 0;
        while(list.size() >= 2){
            if(list.get(list.size()-i-1) + list.get(i) <= limit){
                boats++;
                list.remove(i);
                list.remove(list.size()-i-1);
            }
            else if(list.get(i) + list.get(i+1) <= limit){
                        boats++;
                        list.remove(i);
                        list.remove(i+1);
            }
            else{
                boats++;
                list.remove(i);
            }
        }
        if(list.size() == 1){
            boats++;
        }
        return boats;
    }
}
*/