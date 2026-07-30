class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = 0;
        while (right < s.length()) {
            if (charMap.containsKey(s.charAt(right))) {
                // left = charMap.get(s.charAt(right)) + 1;
                left = Math.max(left, charMap.get(s.charAt(right)) + 1);
            }
            charMap.put(s.charAt(right), right);
            right++;
            length = Math.max(length, right - left);

        }
        return length;
    }
}
