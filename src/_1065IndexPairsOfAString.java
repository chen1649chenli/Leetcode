import java.util.*;

public class _1065IndexPairsOfAString {
    private static class TreeNode {
        boolean end;
        TreeNode[] children = new TreeNode[26];

        public void insert(String str){
            TreeNode currNode = this;
            for (char c: str.toCharArray()){
                if (currNode.children[c - 'a'] == null){
                    currNode.children[c - 'a'] = new TreeNode();
                }
                currNode = currNode.children[c - 'a'];
            }
            currNode.end = true;
        }
    }

    public int[][] indexPairs(String text, String[] words) {
        TreeNode root = new TreeNode();
        PriorityQueue<int[]> ans = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });
        for (String word: words){
            root.insert(word);
        }
        for (int i = 0; i < text.length(); i += 1){
            TreeNode curr = root;
            int j = i;
            while(j < text.length()  && curr.children[text.charAt(j) - 'a'] != null){
                curr = curr.children[text.charAt(j) - 'a'];
                if (curr.end){
                    ans.add(new int[]{i, j});
                    System.out.println(i + " " + j);
                }
                j += 1;
            }
        }

        int size = ans.size();
        int[][] res = new int[size][2];
        for (int i = 0; i < size; i ++){
            res[i] = ans.poll();
        }
        return res;
    }
}
