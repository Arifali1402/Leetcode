class Solution {
    public boolean checkValidString(String s) {
        int maxi = 0;
        int mini = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                // Increase the max and min by 1
                maxi++;
                mini++;
            }
            else if(s.charAt(i) == ')'){
                // Decrease the max and min by 1
                maxi--;
                if(mini > 0){
                    mini--;
                }
            }
            else if(s.charAt(i) == '*'){
                // Increase the max by 1 and decrease min by 1
                maxi++;
                if(mini > 0){
                    mini--;
                }
            }
            // If maxi becomes negative at any point, then it is not valid
            if(maxi < 0){
                return false;
            }
        }
        // Mini should be zero in order to make the string valid
        return mini == 0;
    }
}