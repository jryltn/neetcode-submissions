class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Vals = new int[26];
        int[] s2Vals = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            s1Vals[s1.charAt(i) - 'a']++;
            s2Vals[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        for(int j = 0; j < 26; j++) {
            if(s1Vals[j] == s2Vals[j]) matches++;
        }

        if(matches == 26) return true;

        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++) {
            int lIdx = s2.charAt(l) - 'a';
            int rIdx = s2.charAt(r) - 'a';

            s2Vals[lIdx]--;
            if(s1Vals[lIdx] == s2Vals[lIdx]) matches++;
            else if (s1Vals[lIdx] == (s2Vals[lIdx] + 1)) matches--;

            s2Vals[rIdx]++;
            if(s1Vals[rIdx] == s2Vals[rIdx]) matches++;
            else if (s1Vals[rIdx] == s2Vals[rIdx] - 1) matches--;

            if(matches == 26) return true;
            l++;
        }

        return false;
    }
}
