package offer;

import org.junit.Test;

/**
 * Created by Afauria on 2021/12/2.
 */
//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
public class offer19 {
    @Test
    public void main() {
        TreeNode root =new TreeNode(1);
        root.left =new TreeNode(2);
        root.right =new TreeNode(2);
        root.left.left =new TreeNode(3);
        root.left.right =new TreeNode(4);
        root.right.left =new TreeNode(4);
        root.right.right =new TreeNode(3);
        System.out.println(isSymmetric(root));
    }

    //同时递归比较左子树和右子树
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    private boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
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
