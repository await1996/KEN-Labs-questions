package LeetCode_Algo;

class LeetCode208 {
    class TreeNode {
        boolean isTail;
        TreeNode[] next;

        TreeNode() {
            isTail = false;
            next = new TreeNode[26];
        }
    }

    TreeNode root;
    public LeetCode208() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode cur = root;
        for (int i = 0;i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            if (cur.next[index] == null) {
                cur.next[index] = new TreeNode();
            }

            cur = cur.next[index];
        }

        cur.isTail = true;
    }

    public boolean search(String word) {
        TreeNode cur = root;
        for (int i = 0;i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            if (cur.next[index] == null) {
                return false;
            }

            cur = cur.next[index];
        }
        return cur.isTail;
    }

    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for (int i = 0;i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';

            if (cur.next[index] == null) {
                return false;
            }

            cur = cur.next[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */