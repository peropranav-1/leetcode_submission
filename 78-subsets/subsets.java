class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getAllSubset(0, res, new ArrayList<>(), nums);
        return res;
    }

    public static void getAllSubset(int index, List<List<Integer>> res, List<Integer> ans, int[] nums) {
        if (index == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        } else {
            ans.add(nums[index]);
            getAllSubset(index + 1, res, ans, nums);

            ans.removeLast();
            getAllSubset(index + 1, res, ans, nums);
        }
    }
}