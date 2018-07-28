package Facebook;

public class LC_208_Trie {

    class TrieNode {
        public char val;
        public boolean isWord = false;
        public TrieNode[] childs = new TrieNode[26];
        public TrieNode(char c) {
            val = c;
        }
    }

    public TrieNode root;

    /** Initialize your data structure here. */
    public LC_208_Trie() {
        root = new TrieNode('a');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.childs[c - 'a'] == null) {
                curr.childs[c - 'a'] = new TrieNode(c);
            }
            curr = curr.childs[c - 'a'];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.childs[c - 'a'] == null) return false;
            curr = curr.childs[c - 'a'];
        }
        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.childs[c - 'a'] == null) return false;
            curr = curr.childs[c - 'a'];
        }
        return true;
    }
}
