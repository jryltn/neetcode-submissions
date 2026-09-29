class Solution {
    
    // time complexity m*4^n, where m = board and n = word
    // space complexity= n, where n = word

    // return dfs(board, word, checker, idx, l, r)

    public boolean exist(char[][] board, String word) {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                if(dfs(board, word, new boolean[board.length][board[0].length], 0, r, c)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] checker, int idx, int r, int c) {
        if(idx >= word.length()) return true;
        if(r < 0 || c < 0 
            || r >= board.length 
            || c >= board[r].length 
            || checker[r][c] == true
            || word.charAt(idx) != board[r][c]
        ) return false;

        checker[r][c] = true;
        boolean found = (
            dfs(board, word, checker, idx+1, r, c + 1) ||
            dfs(board, word, checker, idx+1, r + 1, c) ||
            dfs(board, word, checker, idx+1, r, c - 1) ||
            dfs(board, word, checker, idx+1, r - 1, c)
        );

        checker[r][c] = false;
        return found;
    }
}
