class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans1 = combinationSumLC2(candidates, target,
                new ArrayList<>(), 0, new ArrayList<>());
        return ans1;
    }

    public List<List<Integer>> combinationSumLC2(int[] arr, int target,
            List<Integer> ans, int index, List<List<Integer>> finalAns) {

        if (target == 0) {
            finalAns.add(new ArrayList<>(ans));
            return finalAns;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1])
                continue;
            if(arr[i]> target) continue;    
            ans.add(arr[i]);
            combinationSumLC2(arr, target - arr[i], ans, i + 1, finalAns);
            ans.removeLast();
        }

        return finalAns;
    }
}