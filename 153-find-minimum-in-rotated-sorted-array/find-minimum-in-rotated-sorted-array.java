class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if(nums[mid] >= nums[l]) { // left is sorted
                ans = Math.min(ans, nums[l]);
                l = mid + 1;
            } else { // right is sorted
              ans = Math.min(ans, nums[mid]);
              r = mid - 1;
            }
        }
        return ans;
    }
}