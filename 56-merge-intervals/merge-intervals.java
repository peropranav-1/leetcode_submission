class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);
        List<int[]> ans = new ArrayList<>();
        int compareNum = intervals[0][1];
        ans.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (ans.getLast()[1] < intervals[i][0]) {
                ans.add(intervals[i]);
            } else {
                if (ans.get(ans.size() - 1)[1] < intervals[i][1]) {
                    ans.get(ans.size() - 1)[1] = intervals[i][1];
                }
            }
        }
        return ans.toArray(new int[0][]);
    }
}