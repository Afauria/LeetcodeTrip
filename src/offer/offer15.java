package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Afauria on 2021/12/1.
 */
//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。每一层打印到一行
public class offer15 {
    @Test
    public void main() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(7);
        root.right.right.left.left = new TreeNode(8);
        root.right.right.left.left.left = new TreeNode(98);
        root.right.right.left.left.right = new TreeNode(98);
        for (List t : levelOrder1(root)) {
            System.out.println(t);
        }
    }

    //广度优先搜索需要借助队列
    //思路1：使用队列，遍历打印当前层所有节点，同时把下一层节点入队
    public List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.add(root);
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(tmp);
        }
        return result;
    }

    //思路2：使用递归，先序遍历。记录当前深度，放到对应层级的列表中
    List<List<Integer>> ret;

    public List<List<Integer>> levelOrder2(TreeNode root) {
        ret = new ArrayList<>();
        dfs(0, root);
        return ret;
    }

    private void dfs(int depth, TreeNode root) {
        if (root == null) {
            return;
        }
        if (ret.size() == depth) {
            ret.add(new ArrayList<>());
        }
        ret.get(depth).add(root.val);
        dfs(depth + 1, root.left);
        dfs(depth + 1, root.right);
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
