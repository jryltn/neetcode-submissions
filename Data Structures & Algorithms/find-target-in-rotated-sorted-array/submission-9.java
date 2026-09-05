class Solution {
    public int search(int[] nums, int target) {
        //  [1,0,3,2]
        //  check which side is sorted, compare against sorted
        //  [3,0,1,2]
        // check mid > L
        // - if true, left sorted, check if value within
        // - if false, right sorted, check if value within

        int l = 0, r = nums.length - 1;

        while(l <= r) {
            int mid = l + (r-l)/2;
            int midVal = nums[mid];

            if(midVal == target) return mid;

            if(midVal >= nums[l]) {
                if(target >= nums[l] && target < midVal) r = mid - 1;  
                else l = mid + 1;
            } else {
                if(target > midVal && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }

        return -1;
    }
}
