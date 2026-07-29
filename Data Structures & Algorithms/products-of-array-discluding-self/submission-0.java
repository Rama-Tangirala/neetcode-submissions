class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int pre = 1;

        for(int i = 0; i < nums.length; i++){
            answer[i] = pre;
            pre *= nums[i];
        }

        int suf = 1;

        for(int i = nums.length - 1; i >= 0; i--){
            answer[i] *= suf;
            suf *= nums[i];
        }

        return answer;
    } 
}