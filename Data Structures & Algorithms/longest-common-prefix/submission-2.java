class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        String shortest = Arrays.stream(strs)
            .reduce((a, b) -> a.length() > b.length() ? b : a)
            .orElse("");

        int res = shortest.length();
        System.out.println(shortest);

        for(String i : strs) {
            for(int j = 0; j < res; j++) {
                if(shortest.charAt(j) != i.charAt(j)) {
                    res = j;
                    break;
                }
            }
        }

        return shortest.substring(0, res);
    }
}