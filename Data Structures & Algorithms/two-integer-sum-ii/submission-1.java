class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int currentSum = 0;
        while (start < end) {
            currentSum = numbers[start] + numbers[end];
            if (currentSum == target) {
                break;
            }
            if (currentSum < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{start + 1, end + 1};
    }
}
