class Solution {
    public int characterReplacement(String s, int k) {
        // track max Freq within range
        // r - l + 1 - maxFreq > k, start popping
        // track freq of each character
        
        Map<Character, Integer> freq = new HashMap<>();
        int l = 0;
        int maxFreq = 0;
        int res = 0;
        for(int r = 0; r < s.length(); r++) {
            
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(s.charAt(r)));
            while(r - l + 1 - maxFreq > k) {
                char lChar = s.charAt(l);
                freq.computeIfPresent(lChar, (key,v) -> v - 1);
                l++;
            }

            res = Math.max(res, r-l+1);

        }

        return res;
     }

}
