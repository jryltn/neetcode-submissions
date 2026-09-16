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
    // use a q, 
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> curRes = new ArrayList<>();
            for(int i = q.size(); i > 0; i--) {
                if(q.isEmpty()) break;
                TreeNode popped = q.poll();
                curRes.add(popped.val);
                if(popped.left != null) q.offer(popped.left);
                if(popped.right != null) q.offer(popped.right);
            }
            res.add(curRes);
        }

        return res;
    }
}
