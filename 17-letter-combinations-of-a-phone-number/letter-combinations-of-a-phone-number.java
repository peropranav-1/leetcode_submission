class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> finalAns = new ArrayList<>();
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        getLetterCombination(finalAns, "", 0, digits, phoneMap);
        return finalAns;

    }

    public static void getLetterCombination(List<String> finalAns, String ans, int index,
            String digits, Map<Character, String> phoneMap) {
        if (index == digits.length()) {
            finalAns.add(ans);
        } else {
            for (int i = 0; i < phoneMap.get(digits.charAt(index)).length(); i++) {
                ans = ans + phoneMap.get(digits.charAt(index)).charAt(i);
                getLetterCombination(finalAns, ans, index + 1, digits, phoneMap);
                ans = ans.substring(0, index);
            }
        }
    }
}