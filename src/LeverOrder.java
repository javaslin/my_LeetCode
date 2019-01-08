import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
429. N叉树的层序遍历
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个 3叉树 :

返回其层序遍历:

[
     [1],
     [3,2,4],
     [5,6]
]


说明:

树的深度不会超过 1000。
树的节点总数不会超过 5000。
 */
public class LeverOrder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<Node> queue = new LinkedList<Node>();
        if (root == null)
            return new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            ArrayList<Integer> subList = new ArrayList<Integer>();
            while (count > 0) {
                Node node = queue.poll();
                subList.add(node.val);
                for (Node child : node.children) {
                    queue.add(child);
                }
                count--;
            }
            res.add(subList);
        }
        return res;
    }
}
