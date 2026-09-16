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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;
        q.offer(root);

        while(!q.isEmpty()) {
            int curSize = q.size();
            for(int i = curSize; i > 0; i--) {
                if(q.isEmpty()) break;
                TreeNode curNode = q.poll();
                if(i == curSize) res.add(curNode.val);
                if(curNode.right != null) q.offer(curNode.right);
                if(curNode.left != null) q.offer(curNode.left);
            }
        }

        return res;
        
    }
}
