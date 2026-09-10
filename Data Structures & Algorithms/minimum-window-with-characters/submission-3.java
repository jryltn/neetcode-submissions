class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        String res = "";
        int resLen = Integer.MAX_VALUE;

        Map<Character, Integer> refMap = new HashMap<>();
        Map<Character, Integer> valMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            refMap.put(c, refMap.getOrDefault(c, 0) + 1);
            valMap.put(c, 0);
        }

        int val = 0;
        int ref = refMap.size();

        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char rChar = s.charAt(r);

            Integer rCharCnt =
                valMap.computeIfPresent(rChar, (k, v) -> v + 1);

            if (rCharCnt != null &&
                rCharCnt.equals(refMap.get(rChar))) {
                val++;
            }

            while (ref == val && l <= r) {

                int currLen = r - l + 1;

                if (currLen < resLen) {
                    resLen = currLen;
                    res = s.substring(l, r + 1);
                }

                char lChar = s.charAt(l);

                if (valMap.containsKey(lChar)) {
                    valMap.put(lChar, valMap.get(lChar) - 1);

                    if (valMap.get(lChar) < refMap.get(lChar)) {
                        val--;
                    }
                }

                l++;
            }
        }

        return res;
    }
}