class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new LinkedList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            // Convert it into character array
            char[] charArr = str.toCharArray();
            // sort it
            Arrays.sort(charArr);
            // Sorted String
            String newStr = new String(charArr);
            // check if it is in map
            if(map.containsKey(newStr)){
                map.get(newStr).add(str);
            }
            else{
                List<String> list = new LinkedList<>();
                list.add(str);
                map.put(newStr,list);
            }
        }
        for(Map.Entry<String,List<String>> m : map.entrySet()){
            List<String> a = m.getValue();
            ans.add(a);
        }
        return ans;
    }
}