class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length * 2];

        for(int j = 0; j < nums.length; j++) {
            res[j] = nums[j];
        }

        for(int i = nums.length; i < res.length; i++) {
            res[i] = nums[i - nums.length];
        }

        return res;
    }
}