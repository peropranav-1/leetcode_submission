class Solution {
    public int numberOfSubstrings(String s) {
        int[] hash = new int[3];
        int r = 0;
        int l = 0;
        int count = 0;
        int n = s.length();
        while (r < n) {
            hash[s.charAt(r) - 'a']++;
            while (isValidWindow(hash)) {
                count = (count + 1)  + (n - r - 1);
                hash[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return count;
    }

    boolean isValidWindow(int[] hash) {
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 0) {
                return false;
            }
        }
        return true;
    }
}