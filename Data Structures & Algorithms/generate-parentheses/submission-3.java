class Solution {
    public List<String> generateParenthesis(int n) {
        // backtrack
        // variables: res, cur, open, close
        // base, string == n * 2, add to res
        // open < close && open < n, add to open
        
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, 
        StringBuilder s, 
        int open, 
        int close, 
        int n
    ) {
        if(s.length() == n*2) {
            res.add(s.toString());
            return;
        }

        if(open < n) {
            s.append('(');
            backtrack(res, s, open + 1, close, n);
            s.deleteCharAt(s.length() - 1);
        }

        if(close < open && close < n) {
            s.append(')');
            backtrack(res, s, open, close + 1, n);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
