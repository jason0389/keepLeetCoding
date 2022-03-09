package org.jason.lc.easy;

/**
 * @description: https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * @author: Administrator
 * @date: 2022/3/8 15:17
 */
public class LC543 {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;

    }

    public int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        } else {
            int l = dfs(node.left);
            int r = dfs(node.right);
            max = (max > (l + r) ? max : (l + r));
            return (l > r ? l : r) + 1;
        }
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
