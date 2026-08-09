class Solution {
    public int splitArray(int[] nums, int k) {
        int maxPages = 0;
        int startPages = 0;
        for (int num : nums) {
            maxPages = maxPages + num;
        }
        for (int num : nums) {
            startPages = Math.max(num, startPages);
        }

        while (startPages <= maxPages) {
            int mid = (startPages + maxPages) / 2;
            int studentCount = getStudentCount(nums, mid);
            if (studentCount <= k) {
                maxPages = mid - 1;
            } else {
                startPages = mid + 1;
            }

        }
        return startPages;
    }

    // 10 to 32
    private int getStudentCount(int[] nums, int pages) {
        int pagesPerStudent = 0;
        int studentCount = 1;

        for (int i = 0; i < nums.length; i++) {
            if (pagesPerStudent + nums[i] <= pages) {
                pagesPerStudent = pagesPerStudent + nums[i];
            } else {
                pagesPerStudent = nums[i];
                studentCount++;
            }
        }
        return studentCount;
    }
}