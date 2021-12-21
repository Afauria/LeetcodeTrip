package daily;

import org.junit.Test;

import javax.swing.tree.TreeNode;

/**
 * Created by Afauria on 2020/5/5.
 */
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
//假设一个二叉搜索树具有如下特征：
//        节点的左子树只包含小于当前节点的数。
//        节点的右子树只包含大于当前节点的数。
//        所有左子树和右子树自身必须也是二叉搜索树。
//示例 1:
//        输入:
//         2
//        / \
//       1   3
//        输出: true
//      输入:
//             5
//            / \
//           1   4
//             / \
//             3   6
//            输出: false
//            解释: 输入为: [5,1,4,null,null,3,6]。
//            根节点的值为 5 ，但是其右子节点值为 4 。
public class Middle2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void main() {
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(3);
        System.out.println(isValidBST(tree));

        TreeNode tree2 = new TreeNode(5);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(4);
        tree2.right.left = new TreeNode(3);
        tree2.right.right = new TreeNode(6);
        System.out.println(isValidBST(tree2));

        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(1);
        System.out.println(isValidBST(tree3));

        TreeNode tree4 = new TreeNode(10);
        tree4.left = new TreeNode(5);
        tree4.right = new TreeNode(15);
        tree4.right.left = new TreeNode(6);
        tree4.right.right = new TreeNode(20);
        System.out.println(isValidBST(tree4));
    }

    long pre = Long.MIN_VALUE;
    //中序遍历：左、根、右节点，中序遍历二叉搜索树一定是升序
    //pre表示当前节点的前一个节点
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
}
