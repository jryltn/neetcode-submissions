class PrefixTree {

    Trie parent;

    public PrefixTree() {
        parent = new Trie();
    }

    public void insert(String word) {
        Trie cur = parent;
        for(char l : word.toCharArray()) {
            Trie[] curChild = cur.child;
            if(curChild[l - 'a'] == null) {
                curChild[l - 'a'] = new Trie();
            }
            cur = curChild[l - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        Trie cur = parent;
        for(char l : word.toCharArray()) {
            Trie[] curChild = cur.child;
            if(curChild[l - 'a'] == null) {
                return false;
            }
            cur = curChild[l - 'a'];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie cur = parent;
        for(char l : prefix.toCharArray()) {
            Trie[] curChild = cur.child;
            if(curChild[l - 'a'] == null) {
                return false;
            }
            cur = curChild[l - 'a'];
        }
        return true;        
    }

    private static class Trie {
        Trie[] child = new Trie[26];
        boolean isWord = false;
    }
 }
