class Solution {
    public int climbStairs(int n) {
        // int[] dp = new int[n + 1];
        // return numberOfWay(n, dp);

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return numberOfWay(n, 1, 1);
    }

    // private int numberOfWay(int n, int[] dp) {
    //     if (n == 0 || n == 1) {
    //         return 1;
    //     }
    //     if (dp[n] != 0) {
    //         return dp[n];
    //     }
    //     int resp = numberOfWay(n - 1, dp) + numberOfWay(n - 2, dp);
    //     dp[n] = resp;
    //     return resp;
    // }
    private int numberOfWay(int n, int prev0, int prev1) {
        for (int i = 2; i <= n; i++) {
            int cur = prev0 + prev1;
            prev0 = prev1;
            prev1 = cur;
        }
        return prev1;
    }

}