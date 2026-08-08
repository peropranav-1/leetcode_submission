class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        if (nums.length <= 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        int n = nums.length;
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            if (mid % 2 == 1 && nums[mid] == nums[mid - 1]
                    || mid % 2 == 0 && nums[mid] == nums[mid + 1]) {
                // which means mid in left side
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l];
    }
}