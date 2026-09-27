class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // res, cur, idx, nums
        // base = if null || length == nums length - 1, add to res
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(res, cur, 0, nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int idx, int[] nums) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        cur.add(nums[idx]);
        backtrack(res, cur, idx + 1, nums);

        cur.remove(cur.size() - 1);
        while(idx + 1 < nums.length && nums[idx] == nums[idx+1]) idx++;
        backtrack(res, cur, idx + 1, nums);
    }
}
