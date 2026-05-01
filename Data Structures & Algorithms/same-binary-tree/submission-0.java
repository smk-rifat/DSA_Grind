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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(p);
        q2.add(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();
            if (size1 != size2)
                return false;
            for (int i = 0; i < size1; i++) {
                TreeNode left = q1.poll();
                TreeNode right = q2.poll();
                if (left == null && right == null)
                    continue;
                if ((left == null || right == null) || left.val != right.val)
                    return false;
                q1.add(left.left);
                q1.add(left.right);
                q2.add(right.left);
                q2.add(right.right);
            }
        }
        
        return true;
    }
}
