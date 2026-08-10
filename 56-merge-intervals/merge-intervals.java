class Solution {
    public int[][] merge(int[][] intervals) {
        sortInterval(intervals);
        List<int[]> mergedAns = new ArrayList<>();
        mergedAns.add(intervals[0]);
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (mergedAns.get(j)[1] >= intervals[i][0]) {
                if (intervals[i][1] <= (mergedAns.get(j)[1])) {
                    continue;
                }
                mergedAns.get(j)[1] = intervals[i][1];
            } else {
                mergedAns.add(intervals[i]);
                j++;
            }
        }
        return mergedAns.toArray(new int[0][]);

    }

    private void sortInterval(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    }
}