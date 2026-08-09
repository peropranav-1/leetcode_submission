class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        String newS = s + s;
        if (checkStrContains(newS, goal)) {
            return true;
        }
        return false;
    }

    private boolean checkStrContains(String newS, String goal) {
        int goalL = goal.length();
        int newSL = newS.length();
        for (int i = 0; i < newSL - goalL; i++) {
            int j = 0;
            while (j < goalL && newS.charAt(i + j) == goal.charAt(j)) {
                j++;
            }
            if (j == goalL)
                return true;
        }
        return false;
    }
}