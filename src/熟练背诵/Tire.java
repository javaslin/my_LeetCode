package 熟练背诵;

class Trie {
    static final int N = 26;

    private TrieNode root;

    public static class TrieNode {
        int times;
        TrieNode[] children = new TrieNode[N];


        TrieNode() {
            times = 0;
            for (int i = 0; i < N; i++) {
                children[i] = null;
            }
        }
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;

        int n = word.length();

        for (int i = 0; i < n - 1; i++) {
            int index = word.charAt(i) - 'a';

            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.times++;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        int n = word.length();
        for (int i = 0; i < n - 1; i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }

        return node.times > 0;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int n = prefix.length();
        for (int i = 0; i < n - 1; i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }

        return true;

    }
}