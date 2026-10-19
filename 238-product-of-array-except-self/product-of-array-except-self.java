class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int suffix = 1;
        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            suffix = nums[i - 1] * suffix;
            output[i] = suffix;
        }

        int postFix = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            postFix = nums[j + 1] * postFix;
            output[j] = output[j] * postFix;
        }

        return output;
    }
}