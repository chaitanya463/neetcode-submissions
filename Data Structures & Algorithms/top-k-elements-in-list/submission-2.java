class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurences = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            occurences.put(nums[i], occurences.getOrDefault(nums[i], 0) + 1);
        }

        List[] listArr = new List[nums.length];
        for (int i = 0; i < listArr.length; i++) {
            listArr[i] = new ArrayList();
        }

        for (Map.Entry<Integer, Integer> entry : occurences.entrySet()) {
            listArr[entry.getValue() - 1].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = listArr.length - 1; i >= 0 && index < k; i--) {
            List<Integer> bucket = listArr[i];
            int j = 0;
            while (bucket.size() > j) {
                if ( index == k) {
                    break;
                }
                result[index] = bucket.get(j);
                j++;
                index++;
            }
        }
        return result;
    }
}
