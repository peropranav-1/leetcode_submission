class Solution {
    public int rob(int[] nums) {
        // int[] dp = new int[nums.length];
        // for (int i = 0; i < dp.length; i++) {
        //     dp[i] = -1;
        // }
        // return getRob(nums.length - 1, nums, dp);

        // return getRobTabulation(nums);

        return getRobTabulationWithSpaceOptimization(nums);
    }

    // private int getRob(int index, int[] nums, int[] dp) {
    //     if (index == 0)
    //         return nums[0];
    //     if (index < 0)
    //         return 0;
    //     if (dp[index] != -1)
    //         return dp[index];

    //     int pick = nums[index] + getRob(index - 2, nums, dp);
    //     int nonPick = 0 + getRob(index - 1, nums, dp);

    //     dp[index] = Math.max(pick, nonPick);
    //     return dp[index];
    // }

    private int getRobTabulation(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int index = 1; index < nums.length; index++) {
            int pick = nums[index];

            if (index > 1)
                pick = pick + dp[index - 2];
            int nonPick = 0 + dp[index - 1];

            dp[index] = Math.max(pick, nonPick);
        }

        return dp[nums.length - 1];
    }

    private int getRobTabulationWithSpaceOptimization(int[] nums) {
        int prev = nums[0];
        int prePrev = 0;

        for (int index = 1; index < nums.length; index++) {
            int pick = nums[index];

            if (index > 1)
                pick = pick + prePrev;
            int nonPick = 0 + prev;

            prePrev = prev;
            prev = Math.max(pick, nonPick);
        }

        return prev;
    }
}