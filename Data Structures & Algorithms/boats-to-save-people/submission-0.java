class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, boats = 0;
        int right = people.length - 1;
        while(left <= right){
            int weight = people[left] + people[right];
            if(weight <= limit){
                left++;
                right--;
            } else{
                right--;
            }
            boats++;
        }
        return boats;
    }
}