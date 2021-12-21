package offer;

import org.junit.Test;

import java.util.*;

/**
 * Created by Afauria on 2021/12/2.
 */
//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
public class offer18 {
    @Test
    public void main() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        mirrorTree1(root);
    }

    //思路1：广度优先遍历，借助栈，交换左右节点
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack() {{
            add(root);
        }};
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

    //思路2：广度优先遍历，借助队列，交换左右节点
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList() {{
            add(root);
        }};
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) queue.offer(node.right);
            if (node.left != null) queue.offer(node.left);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

    //思路3：递归，镜像反转左子树，镜像反转右子树，交换左右子树
    public TreeNode mirrorTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftRoot = mirrorTree3(root.right);
        TreeNode rightRoot = mirrorTree3(root.left);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }

    //思路4：递归，新建树B。B右子树等于A的左子树、B左子树等于A的右子树
    public TreeNode mirrorTree4(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        dfs(root, node);
        return node;
    }

    private void dfs(TreeNode node, TreeNode node2) {
        if (node == null) {
            return;
        }
        if (node.right != null) {
            node2.left = new TreeNode(node.right.val);
        }
        if (node.left != null) {
            node2.right = new TreeNode(node.left.val);
        }
        dfs(node.left, node2.right);
        dfs(node.right, node2.left);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
