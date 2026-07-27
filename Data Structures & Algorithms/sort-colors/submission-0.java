class Solution {
    public void sortColors(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int index = 0;

        for (Integer color : map.keySet()) {

            int freq = map.get(color);

            while (freq-- > 0) {
                nums[index++] = color;
            }
        }
    }
}