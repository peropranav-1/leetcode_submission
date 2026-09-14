class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Set<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int tp = nums[i] + nums[j];
                if (hash.contains(-tp)) {
                    List<Integer> miniAns = new ArrayList<>();
                    miniAns.add(nums[i]);
                    miniAns.add(nums[j]);
                    miniAns.add(-tp);
                    Collections.sort(miniAns);
                    ans.add(miniAns);
                } else {
                    hash.add(nums[j]);
                }
            }
            hash.clear();
        }
        return new ArrayList<>(ans);
    }
}