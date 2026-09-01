class Solution {
    public int splitArray(int[] nums, int k) {

        int left = 0;
        int right = 0;

        // Minimum possible answer = largest element
        // Maximum possible answer = total sum
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        // Binary search on the answer
        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                // mid works, try a smaller maximum sum
                right = mid;
            } else {
                // mid doesn't work, need a larger maximum sum
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {

        int parts = 1;
        int currentSum = 0;

        for (int num : nums) {

            if (currentSum + num > maxSum) {
                parts++;
                currentSum = 0;
            }

            currentSum += num;
        }

        return parts <= k;
    }
}