package daily;

import org.junit.Test;

/**
 * Created by Afauria on 2020/5/7.
 */
//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
//
//        示例 1:
//        给定的树 s:
//
//        3
//        / \
//        4   5
//        / \
//        1   2
//        给定的树 t：
//
//        4
//        / \
//        1   2
//        返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
//
//        示例 2:
//        给定的树 s：
//
//        3
//        / \
//        4   5
//        / \
//        1   2
//        /
//        0
//        给定的树 t：
//
//        4
//        / \
//        1   2
//        返回 false。
public class Easy3 {
    public class TreeNode {
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

    @Test
    public void main() {
        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(4);
        tree1.left.left = new TreeNode(1);
        tree1.left.right = new TreeNode(2);
        tree1.right = new TreeNode(5);

        TreeNode subtree1 = new TreeNode(4);
        subtree1.left = new TreeNode(1);
        subtree1.right = new TreeNode(2);
        System.out.println(isSubtree(tree1, subtree1));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    /**
     * 深度优先遍历
     */
    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return isEqualTree(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    /**
     * 判断两棵树是否相等
     * 有一个节点不相等则树不相等
     */
    private boolean isEqualTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isEqualTree(s.left, t.left) && isEqualTree(s.right, t.right);
    }
}
