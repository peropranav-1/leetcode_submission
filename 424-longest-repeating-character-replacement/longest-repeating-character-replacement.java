class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int[] hash = new int[26];
        int maxLen = 0;
        while (r < s.length()) {
            hash[s.charAt(r) - 'A']++;
                while (r - l + 1 - getMaxCharInWin(hash) > k) {
                    hash[s.charAt(l) - 'A']--;
                    l++;
                }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    private int getMaxCharInWin(int[] hash) {
        int max = 0;
        for (int j : hash) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
}