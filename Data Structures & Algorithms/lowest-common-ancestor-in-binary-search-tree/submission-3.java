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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode a = p.val < q.val ? p : q;
        TreeNode b = p.val >= q.val ? p : q;
        if(root.val >= a.val && root.val <= b.val) return root;
        else if(root.val <= a.val && root.val <= b.val) {
            return lowestCommonAncestor(root.right, a, b);
        } else {
            return lowestCommonAncestor(root.left, a, b);
        }
    }
}
