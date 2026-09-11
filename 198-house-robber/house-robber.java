class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return getRob(nums.length - 1, nums, dp);
    }

    private int getRob(int index, int[] nums, int[] dp) {
        if (index == 0)
            return nums[0];
        if (index < 0)
            return 0;
        if (dp[index] != -1)
            return dp[index];

        int pick = nums[index] + getRob(index - 2, nums, dp);
        int nonPick = 0 + getRob(index - 1, nums, dp);

        dp[index] = Math.max(pick, nonPick);
        return dp[index];
    }
}