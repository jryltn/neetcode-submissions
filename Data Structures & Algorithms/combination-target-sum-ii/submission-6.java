class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort candidates for pruning
        // [1,2,2,4,5,6,9]
        // do dfs having to choose or dont choose current option
        // base case: >= target, == target ? append -> return : return 
        // return res

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        backtrack(candidates, res, cur, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, List<List<Integer>> res, List<Integer> cur, int idx, int target) {
        if(idx >= candidates.length || target <= 0) {
            if(target == 0) res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(candidates[idx]);
        backtrack(candidates, res, cur, idx + 1, target - candidates[idx]);
        cur.remove(cur.size() - 1);
        int nextIdx = idx + 1;
        while(nextIdx < candidates.length && candidates[idx] == candidates[nextIdx]) nextIdx++;
        backtrack(candidates, res, cur, nextIdx, target);
    }
}
