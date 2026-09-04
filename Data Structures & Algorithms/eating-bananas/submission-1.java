class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();

        int res = maxPile;

        int l = 1, r = maxPile - 1;

        while(l <= r) {
            int perHr =  l + (r-l)/2;
            int minHr = Arrays.stream(piles)
                .map(i -> (i + perHr - 1)/perHr)
                .sum();

            if(minHr > h) {
                l = perHr + 1;
            } else if (minHr <= h) {
                res = Math.min(res, perHr);
                r = perHr - 1;
            }
        }

        return res;
    }
}
