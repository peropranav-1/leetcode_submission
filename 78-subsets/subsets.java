class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> semiAns =  new ArrayList<>();
        getAns(ans, semiAns, 0, nums);
        return ans;
    }

    private void getAns(List<List<Integer>> ans, List<Integer> semiAns, int index, int[] nums) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(semiAns));
            return;
        }

        semiAns.add(nums[index]);
        getAns(ans, semiAns, index + 1, nums);

        semiAns.remove(Integer.valueOf(nums[index]));
        getAns(ans, semiAns, index + 1, nums);
    }

}