class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));


        int[] res = new int[nums.length - k + 1];
        for(int r = 0; r < nums.length; r++) {
            heap.offer(new int[]{nums[r], r});
            if(r >= k - 1) {
                int l = r - k +1;
                while(!heap.isEmpty() && heap.peek()[1] < l) heap.poll();
                res[l] = heap.peek()[0];
            }
        }
        return res;

    }
}
