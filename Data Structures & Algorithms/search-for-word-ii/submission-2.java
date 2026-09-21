class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Trie root = buildTrie(words);

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(r, c, root, board, res);
            }
        }
        return res;
    }

    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie cur = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (cur.child[idx] == null) {
                    cur.child[idx] = new Trie();
                }
                cur = cur.child[idx];
            }
            cur.isWord = true;
            cur.word = word; // Store the word directly at the terminal node
        }
        return root;
    }

    private void dfs(int r, int c, Trie node, char[][] board, List<String> res) {
        // Boundary checks and visited check (using '#' as visited marker)
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;
        
        char curL = board[r][c];
        if (curL == '#' || node.child[curL - 'a'] == null) return;

        // Move to the next Trie node
        node = node.child[curL - 'a'];
        
        // If we found a valid word, add it and clear it to avoid duplicates
        if (node.isWord) {
            res.add(node.word);
            node.isWord = false; // De-duplicate
        }

        // Mark current cell as visited
        board[r][c] = '#';

        // Explore all 4 directions
        dfs(r + 1, c, node, board, res);
        dfs(r - 1, c, node, board, res);
        dfs(r, c + 1, node, board, res);
        dfs(r, c - 1, node, board, res);

        // Backtrack: restore the cell's original character
        board[r][c] = curL;
    }

    private static class Trie {
        Trie[] child = new Trie[26];
        boolean isWord = false;
        String word = null;
    }
}