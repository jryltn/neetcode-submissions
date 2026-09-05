class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // find the right split between the two arrays
        // - all the left of the two < all the right of the two
        // - left side will always be +1 if odd
        // Edge cases:
        // if we take all of nums1 and nothing from nums2
        // left of nums2 = Integer.MIN_VALUE
        // 
        // - [1,2]
        // - [3,5,6]

        int[] shorter = nums1.length >= nums2.length ? nums2 : nums1;
        int[] longer = nums1.length >= nums2.length ? nums1 : nums2;

        int shortLen = shorter.length;
        int longLen = longer.length;

        int leftCnt = (nums1.length + nums2.length + 1)/2;
        boolean isOdd = ((nums1.length + nums2.length) % 2) > 0 ;

        int l = 0, r = shorter.length;

        while(l <= r) {
            int shortMid = l + (r-l)/2;
            int left1Val = shortMid == 0 ? Integer.MIN_VALUE : shorter[shortMid-1];
            int longMid = leftCnt - shortMid;
            int left2Val = longMid == 0 ? Integer.MIN_VALUE : longer[longMid-1];

            int right1Val = shortMid == shortLen ? Integer.MAX_VALUE : shorter[shortMid];
            int right2Val = longMid == longLen ? Integer.MAX_VALUE : longer[longMid];

            if(left1Val <= right2Val && left2Val <= right1Val) { 
                if(isOdd) return Math.max(left1Val, left2Val);
                else return (Math.max(left1Val, left2Val) + Math.min(right1Val, right2Val)) /2.0;
            } else {
                if(left1Val > right2Val) r = shortMid - 1;
                else l = shortMid + 1;
            }

        }

        return 0.0;
    }
}
