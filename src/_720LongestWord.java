import java.util.LinkedList;
import java.util.Queue;

public class _720LongestWord {
    private static class TrieNode{
        String word;
        TrieNode[] nodes = new TrieNode[26];


        public void insert(String str){
            char[] chs = str.toCharArray();
            TrieNode currNode = this;
            for (char c: chs){
                if (currNode.nodes[c - 'a'] == null){
                    currNode.nodes[c - 'a'] = new TrieNode();
                }
                currNode = currNode.nodes[c - 'a'];
            }
            currNode.word = str;
        }
    }

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (String str: words){
            root.insert(str);
        }
        root.word = "";
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        String res = "";
        while(q.size() > 1){
            TrieNode node = q.poll();
            if (node == null){
                q.add(null);
                continue;
            }
            for (TrieNode n_ : node.nodes){
                if (n_ != null && n_.word != null){
                    q.add(n_);
                }
            }
            if ((node.word.length() > res.length()) ||
                    ((node.word.length() == res.length()) && node.word.compareTo(res) < 0)){
                res = node.word;
            }
        }
        return res;
    }
}
