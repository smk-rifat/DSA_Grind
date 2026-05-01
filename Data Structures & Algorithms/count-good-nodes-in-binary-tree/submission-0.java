/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        int ans = 0;
        if(root == null) return ans;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, Integer.MIN_VALUE));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int max = pair.max;
                if(node.val >= max){
                    ans++;
                }
                if(node.left != null){
                    queue.add(new Pair(node.left, Math.max(max, node.val)));
                }
                if(node.right != null) {
                    queue.add(new Pair(node.right, Math.max(node.val, max)));
                }
            }
        }
        return ans;
    }
}class Pair {
    int max;
    TreeNode node;

    Pair(TreeNode node, int max) {
        this.node = node;
        this.max = max;
    }
}
