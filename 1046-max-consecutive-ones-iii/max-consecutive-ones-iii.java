class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int firstZeroPos = 0;
        int length = 0;
        List<Integer> hashOfZero = new ArrayList<>();

        while (right < nums.length) {
            if (nums[right] == 0) {
                hashOfZero.add(right);
                k--;
            }
            if (k < 0) {
                length = Math.max(length, right - left );
                k = k + 1;
                left = hashOfZero.get(firstZeroPos) + 1;
                firstZeroPos++;
            }
            right++;
        }
        return Math.max(length, right - left );
    }
}