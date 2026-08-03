class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            char curLeft = s.charAt(left);
            char curRight = s.charAt(right);
            if(!Character.isLetterOrDigit(curLeft)){
                left++;
            } else if(!Character.isLetterOrDigit(curRight)){
                right--;
            } else {
                if(Character.toLowerCase(curLeft) != Character.toLowerCase(curRight)){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
