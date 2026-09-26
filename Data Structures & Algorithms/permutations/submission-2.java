class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // for loop back tracking with hashset to hold what has been seen / prevents dupe
        // base case: cur.length >= nums.length, == ? append -> return : return

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        backtrack(res, cur, seen, nums);

        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, Set<Integer> seen, int[] nums) {
        if(cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(seen.contains(nums[i])) continue;
            seen.add(nums[i]);
            cur.add(nums[i]);
            backtrack(res, cur, seen, nums);
            seen.remove(nums[i]);
            cur.remove(cur.size() - 1);
        }
    }
}
