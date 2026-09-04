class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return numberOfWay(n, dp);
    }

    private int numberOfWay(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int resp = numberOfWay(n - 1, dp) + numberOfWay(n - 2, dp);
        dp[n] = resp;
        return resp;
    }
}