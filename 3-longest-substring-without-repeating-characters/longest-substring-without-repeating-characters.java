class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = 0;
        while (right < s.length()) {
            if (charMap.containsKey(s.charAt(right))) {
                length = Math.max(length, right - left);
                int tempLeft = charMap.get(s.charAt(right));
                removeHashChar(left, tempLeft, s, charMap);
                left = tempLeft + 1;
            }
            charMap.put(s.charAt(right), right);
            right++;
            length = Math.max(length, right - left);

        }
        return length;
    }

    private void removeHashChar(int left, int tempLeft, String s, Map<Character, Integer> charMap) {
        while (left <= tempLeft) {
            charMap.remove(s.charAt(left++));
        }
    }
}