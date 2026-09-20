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

    // curNodeVal == null return 0
    // post order traversal ?
    // keep track of highest val so far
    // get sum of left and right branch
    // trim either left or right
    // if either left or right == 0, make left/right = 0
    // 
    int res;

    public int maxPathSum(TreeNode root) {
        this.res = root.val;
        maxSum(root);
        return this.res;
    }

    private int maxSum(TreeNode node) {
        if(node == null) return 0;
        int leftVal = maxSum(node.left);
        int rightVal = maxSum(node.right);

        leftVal = leftVal < 0 ? 0 : leftVal;
        rightVal = rightVal < 0 ? 0 : rightVal;
        int curSum = node.val + leftVal + rightVal;
        this.res = Math.max(curSum, this.res);


        return node.val + Math.max(leftVal, rightVal);
    }
}
