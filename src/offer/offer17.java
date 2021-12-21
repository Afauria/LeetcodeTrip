package offer;

import org.junit.Test;

/**
 * Created by Afauria on 2021/12/2.
 */
//输入两棵二叉树A和B，判断B是不是A的子树。(约定空树不是任意一个树的子结构)
public class offer17 {
    @Test
    public void main() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeNode child = new TreeNode(2);
        child.left = new TreeNode(4);
        System.out.println(isSubStructure(root, child));
    }
    //递归：判断两棵树是否相等 || 左子树是否等于树B || 右子树是否等于树B
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        boolean r1 = recur(A, B);
        boolean r2 = isSubStructure(A.left, B);
        boolean r3 = isSubStructure(A.right, B);
        return r1 || r2 || r3;
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
