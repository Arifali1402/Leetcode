class Solution {
    public int minimumPushes(String word) {
        int freq[] = new int[26];
        for(char ch: word.toCharArray()){
            freq[ch-'a']++;
        }
        // Arrays.sort(freq, Collections.reverseOrder());
        Arrays.sort(freq);
        int count = 0;
        int j = 1;
        int alphabets = 0;
        
        for(int k = freq.length - 1;k>=0;k--){
            if(freq[k] == 0){
                break;
            }
            if(alphabets >= 8){
                j++;
                alphabets = 0;
            }
            alphabets++;
            count = count+(j*freq[k]);            
        }
        return count;
    }
}
/*
class Solution {
    public int minimumPushes(String word) {
        int count = 0;
        // 8 alphabets
        Map<Character, Integer> map = new TreeMap<>();
        for (char ch : word.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        if (map.size() <= 8) {
            return word.length();
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        // list.sort((a,b)->b.getValue().compareTo(a.getValue()));
        list.sort(Map.Entry.comparingByValue());
        int alphabets = 0;
        int j = 1;
        for (int i = list.size()-1; i >= 0; i--) {
            if(alphabets >= 8){
                j++;
                alphabets = 0;
            }
            alphabets++;
            Map.Entry<Character, Integer> entry = list.get(i);
            count = count + (j*entry.getValue());
        }
        return count;
    }
}
*/