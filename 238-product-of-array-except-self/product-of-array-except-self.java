class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int[] suffix = new int[nums.length];
        suffix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            suffix[i] = nums[i - 1] * suffix[i - 1];
        }

        int[] postFix = new int[nums.length];
        postFix[nums.length - 1] = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            postFix[j] = nums[j + 1] * postFix[j + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            output[i] = suffix[i] * postFix[i];
        }
        return output;
    }
}