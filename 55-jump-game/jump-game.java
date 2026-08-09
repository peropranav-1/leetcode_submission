class Solution {
    public boolean canJump(int[] nums) {
        int cur = nums.length - 1;
        int prev = cur - 1;
        while (prev >= 0) {
            if (prev + nums[prev] >= cur) {
                cur = prev;
                prev--;
            } else {
                prev--;
            }
        }

        if (cur == 0)
            return true;
        return false;
    }
}