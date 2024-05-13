class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();// contains all the elements of the nums1
        Set<Integer> s2 = new HashSet<>();// contains all the elements of the nums2
        Set<Integer> s3 = new HashSet<>();// contains the common elements

        for(int e1: nums1){
            s1.add(e1);
        }
        int n1[] = new int[s1.size()];
        int i=0;
        Iterator<Integer> it1 = s1.iterator();
        while(it1.hasNext()){
            // System.out.println(it1.next());
            n1[i++] = it1.next();
        }
        
        for(int e2: nums2){
            s2.add(e2);
            if(s1.contains(e2)){
                s3.add(e2);                
            }
        }

        int n2[] = new int[s2.size()];
        i=0;
        Iterator<Integer> it2 = s2.iterator();
        while(it2.hasNext()){
            // System.out.println(it2.next());
            n2[i++] = it2.next();
        }
        
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        
        for(int e1: n1){
            if(s3.contains(e1))
                continue;
            else
                a1.add(e1);
        }
        
        for(int e2: n2){
            if(s3.contains(e2))
                continue;
            else
                a2.add(e2);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(a1);
        ans.add(a2);
        return ans;
    }
}