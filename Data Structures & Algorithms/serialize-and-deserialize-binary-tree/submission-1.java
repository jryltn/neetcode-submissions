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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        dfsSerialize(root, res);
        System.out.println(res.toString());
        return res.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder res) {
        if(node == null) {
            res.append("NULL");
            res.append(",");
            return;
        }

        res.append(Integer.toString(node.val));
        res.append(",");
        dfsSerialize(node.left, res);
        dfsSerialize(node.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        int[] cnt = new int[]{0};
        return dfsDeserialize(split, cnt);
    }

    private TreeNode dfsDeserialize(String[] split, int[] cnt) {
        if(split[cnt[0]].equals("NULL")) {
            cnt[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(split[cnt[0]++]));
        root.left = dfsDeserialize(split, cnt);
        root.right = dfsDeserialize(split, cnt);
        return root;
    }
}
