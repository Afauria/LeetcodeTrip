package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Afauria on 2021/12/1.
 */
//请实现一个函数按照之字形顺序打印二叉树，
// 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
public class offer16 {
    @Test
    public void main() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        root.right.right.left.left = new TreeNode(8);
        for (List t : levelOrder2(root)) {
            System.out.println(t);
        }
    }

    //广度优先搜索需要借助队列
    //思路1：使用队列，遍历存储当前层所有节点，同时把下一层节点入队。
    // 倒序存储思路1：都插入到尾部，偶数行使用Collection反转列表
    // 倒序存储思路2：奇数行插入到尾部，偶数行插入到头部。使用LinkedList提高效率
    public List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.add(root);
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            //是否插入到头部，偶数层插入到头部
            boolean addHead = result.size() % 2 == 1;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (addHead) {
                    tmp.addFirst(node.val);
                } else {
                    tmp.addLast(node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(tmp);
        }
        return result;
    }

    //思路2：使用递归，先序遍历。记录当前深度，放到对应层级的列表中。倒序做法同上
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
            ret.add(new LinkedList<>());
        }
        //0代表第1层
        if (depth % 2 == 0) {
            ret.get(depth).add(root.val);
        } else {
            ret.get(depth).add(0, root.val);
        }
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
