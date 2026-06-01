class Solution {
    public int[] productExceptSelf(int[] nums) {
        int preFix = 1;
        int postFix = 1;
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = preFix;
            preFix *= nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postFix;
            postFix *= nums[i];
        }
        return result;
    }
}  
