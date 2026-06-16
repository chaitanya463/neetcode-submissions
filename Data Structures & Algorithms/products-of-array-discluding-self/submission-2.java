class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] result = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
         }

         for (int j = nums.length - 2; j >= 0; j--) {
            suffix[j] = suffix[j + 1] * nums[j + 1];
         }
         for (int i = 0; i < result.length; i++) {
            int suffixSum = 1;
            int prefixSum = 1;
            if (i != 0) {
                prefixSum = prefix[i];
            }
            if (i + 1 < result.length) {
                suffixSum = suffix[i];
            }
            result[i] = prefixSum * suffixSum;
         }
         return result;
    }
}  
