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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        kth(root, res);
        return res.get(k-1);
    }

    private void kth(TreeNode root, List<Integer> res) {
        if(root == null) return;
        kth(root.left, res);
        res.add(root.val);
        kth(root.right, res);
    }
}
