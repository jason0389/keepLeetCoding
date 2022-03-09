package org.jason.lc.easy;

/**
 * @description: https://leetcode-cn.com/problems/merge-two-binary-trees/
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。
 * @author: Administrator
 * @date: 2022/3/9 21:39
 */
public class LC617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return root1;
        }
        if (root1 == null && root2 != null) {
            return root2;
        } else if (root2 == null && root1 != null) {
            return root1;
        }
        merge(root1,root2);
        return root1;
    }

    private void merge(TreeNode node1, TreeNode node2) {
        node1.val = node1.val + node2.val;
        if (node1.left != null && node2.left != null) {
            merge(node1.left, node2.left);
        } else if (node1.left == null && node2.left != null) {
            node1.left = node2.left;
            node2.left = null;
        }

        if (node1.right != null && node2.right != null) {
            merge(node1.right, node2.right);
        } else if (node1.right == null && node2.right != null) {
            node1.right = node2.right;
            node2.right = null;
        }


    }
}
