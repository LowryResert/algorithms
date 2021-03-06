package tree;
/**
 * 二分查找树
 */
public class BinarySearchTree {
    // tree的根节点
    private Node tree;

    // 查找
    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) p = p.left;
            else if (data > p.data) p = p.right;
            else return p;
        }
        return null;
    }

    // 插入
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;

        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {    // data < p.data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    // 删除
    public void delete(int data) {
        Node p = tree;      // p指向要删除的节点，初始化指向根节点
        Node pp = null;     // pp维护p的父节点

        // 查找将要删除的数据所在节点
        while (p != null && p.data != data) {
            pp = p;
            if (data < p.data) p = p.left;
            else p = p.right;
        }
        if (p == null) return;  //没有找到

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            // 查找右子树中的最小节点
            Node minP = p.right;
            Node minPP = p;     // 维护minP的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data; // 将minP中的数据替换到p中
            p = minP;           // 现在变成删除minP了
            pp = minPP;
        }

        // 要删除的节点是叶子节点或者仅有一个子节点
        Node child;
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        //执行删除操作
        if (pp == null) tree = null;    // 删除的是根节点
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }

    // 查找data最小节点
    public Node findMin() {
        if (tree == null) return null;

        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
