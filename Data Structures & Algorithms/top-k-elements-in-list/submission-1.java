class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> occurences = new HashMap();
        List<Integer>[] buckets = new ArrayList[nums.length];
        int[] result = new int[k];

        for (int i = 0; i < nums.length; i++) {
            occurences.put(nums[i], occurences.computeIfAbsent(nums[i], key -> 0) + 1);
        }

        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new ArrayList();
        }

        for(int key : occurences.keySet()) {
            System.out.println(" key = " + key + " occurences.get(key) = " +occurences.get(key));
            buckets[occurences.get(key) - 1].add(key);
        }

        int index = 0;
        for (int i = buckets.length - 1; i >= 0 && index < k ; i--) {
            List<Integer> list = buckets[i];
            for (int j = 0; j < list.size(); j++) {
                if(index == k) {
                    break;
                }
                result[index] = list.get(j);
                index++;
            }
        }
        return result;
    }
}
