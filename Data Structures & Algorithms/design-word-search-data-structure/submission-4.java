class WordDictionary {

    Trie parent;

    public WordDictionary() {
        parent = new Trie();
    }

    public void addWord(String word) {
        Trie cur = this.parent;
        for(char c : word.toCharArray()) {
            Trie[] curChild = cur.child;
            if(curChild[c - 'a'] == null) curChild[c-'a'] = new Trie();
            cur = curChild[c-'a'];
        }

        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, this.parent);
    }

    private boolean dfs(String word, int idx, Trie node) {
        if(node == null) return false;
        if(idx >= word.length()) return node.isWord;

        Trie[] child = node.child;
        char curL = word.charAt(idx);
        if(curL == '.') {
            for(Trie i : child) {
                if(i != null && dfs(word, idx+1, i)) return true;
            }
            return false;
        }

        return dfs(word, idx + 1, child[curL - 'a']);
    }

    private static class Trie {
        Trie[] child = new Trie[26];
        boolean isWord = false;
    }
}
