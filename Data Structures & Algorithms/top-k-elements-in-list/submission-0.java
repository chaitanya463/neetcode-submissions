class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        List<Integer>[] buckets = new List[nums.length + 1];
        Map<Integer, Integer> occurenceMap = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(occurenceMap.containsKey(nums[i])){
                occurenceMap.put(nums[i], occurenceMap.get(nums[i]) + 1);
            } else {
                occurenceMap.put(nums[i], 1);
            }
        }
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList();
        }

        for (Map.Entry<Integer, Integer> entry : 
        occurenceMap.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        for (int i = buckets.length - 1; i > 0 && index < k; i--) {
            for (int j = 0; j < buckets[i].size(); j++) {
                result[index++] = buckets[i].get(j);
                if (index == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
