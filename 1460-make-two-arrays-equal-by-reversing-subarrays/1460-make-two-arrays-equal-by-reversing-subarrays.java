class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length){
            return false;
        }
        Arrays.sort(target);
        Arrays.sort(arr);
        int n = target.length;
        for(int i=0;i<n;i++){
            if(target[i] != arr[i]){
                return false;
            }
        }
        return true;
    }
}