class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Len = nums1.length;
        int num2Len = nums2.length;
        int total = num1Len + num2Len;
        int mid = (total - 1) / 2;   // fix #1
        return findMedian(mid, total, nums1, nums2);
    }

    private double findMedian(int mid, int total, int[] nums1, int[] nums2) {
        int m = 0, n = 0;
        int num1Len = nums1.length, num2Len = nums2.length;
        int first = -1, second = -1;

        for (int i = 0; i <= mid + 1 && i < total; i++) {
            int val;
            if (n >= num2Len || (m < num1Len && nums1[m] <= nums2[n])) { 
                val = nums1[m++];
            } else {
                val = nums2[n++];
            }
            if (i == mid) first = val;
            if (i == mid + 1) second = val;
        }

        if (total % 2 == 0) {         
            return (first + second) / 2.0; 
        }
        return first;
    }
}