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

    // map to store inOrder Val to inOrder val's index 
    // recursion function to build tree
    //
    // params = lowLimit, upperLimit - use index

    int preIdx = 0;
    Map<Integer, Integer> inOrdValMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            inOrdValMap.put(inorder[i], i);
        }
        return dfs(0, Integer.MAX_VALUE, preorder);
    }

    private TreeNode dfs(int l, int r, int[] preorder) {
        if(preIdx >= preorder.length || l > r) return null;
        
        TreeNode cur = new TreeNode(preorder[preIdx++]);
        int mid = inOrdValMap.get(cur.val);
        cur.left = dfs(l, mid - 1, preorder);
        cur.right = dfs(mid + 1, r, preorder);

        return cur;
    }
}
