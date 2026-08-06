import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] hashOfS1 = new int[26];
        int[] hashOfS2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            hashOfS1[s1.charAt(i) - 'a']++;
        }
        int l = 0;
        int r = 0;
        while (r < s1.length()) {
            hashOfS2[s2.charAt(r) - 'a']++;
            r++;
        }
        r = s1.length();
        if (Arrays.equals(hashOfS1, hashOfS2))
            return true;
        while (r < s2.length()) {
            hashOfS2[s2.charAt(l) - 'a']--;
            hashOfS2[s2.charAt(r) - 'a']++;
            l++;
            r++;
            if (Arrays.equals(hashOfS1, hashOfS2))
                return true;
        }
        return false;
    }
}