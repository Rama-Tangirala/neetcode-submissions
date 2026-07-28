class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Bucket Sort
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int num : map.keySet()) {

            int freq = map.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }

            bucket[freq].add(num);
        }

        // Step 3: Collect top k frequent elements
        List<Integer> res = new LinkedList<>();

        for (int i = bucket.length - 1; i > 0 && k > 0; i--) {

            if (bucket[i] != null) {

                res.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }

        // Step 4: Convert List<Integer> to int[]
        int[] ans = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}