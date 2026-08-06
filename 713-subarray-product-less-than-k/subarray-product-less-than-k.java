class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int product = 1;
        int count = 0;
        while (r < nums.length) {
            product = product * nums[r];
            while (product >= k && l <= r) {
                product = product / nums[l];
                l++;
            }
            count = count + r - l + 1;
            r++;
        }
        return count;
    }
}