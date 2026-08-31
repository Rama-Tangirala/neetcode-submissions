class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for(int weight: weights){
            left = Math.max(left, weight);
            right += weight;
        }
        while(left < right){
            int mid = left + (right - left)/2;
            if(canShip(weights, mid, days)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean canShip(int[] weights, int capacity, int days){
        int daysUsed = 1;
        int currentLoad = 0;
        for(int weight: weights){
            if(weight + currentLoad > capacity){
                daysUsed++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }
        return daysUsed <= days;
    }
}