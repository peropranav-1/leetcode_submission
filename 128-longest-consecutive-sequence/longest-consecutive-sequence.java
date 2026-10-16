class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }
        int longest = 0;
        for (int num : hash) {
            if(!hash.contains(num - 1)) {
                // this is the start sequence
                int length = 1;
                int current = num;
                while(hash.contains(current+1)) {
                    length++;
                    current++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}