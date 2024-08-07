class Solution {
    private String[] digitString = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private String[] teenString = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen","Eighteen", "Nineteen"};
    private String[] tenString = new String[]{"","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        String[] bigStr = new String[]{"Thousand", "Million", "Billion"};
        String result = helper(num%1000);
        num = num/1000;
        if(num > 0 && num%1000>0){
            result = helper(num%1000)+"Thousand "+result;
        }
        num = num/1000;
        if(num>0 && num%1000>0){
            result = helper(num%1000)+"Million "+result;
        }
        num = num/1000;
        if(num>0 && num%1000>0){
            result = helper(num%1000)+"Billion "+result;
        }
        return result.trim();
    }
    private String helper(int num){
        String result = "";
        if(num>99){
            result += digitString[num/100]+" Hundred ";
        }
        num = num%100;
        if(num>9 && num<20){
            result += teenString[num%10]+" ";
        }
        else{
            if(num>19){
                result += tenString[num/10]+" ";
            }
            num = num%10;

            if(num>0){
                result += digitString[num]+" ";
            }
        }
        return result;
    }
}