package tree;

/**
 * @author toby Zhang
 * @date 2020-03-18 18:02
 * @description
 */
public class BinarySearchTree {

    private Node tree;

    /**
     * 查找
     * @param data
     * @return
     */
    public Node find(int data) {

        //如果当前节点==要查找的值，返回
        // 如果要查找的值v<当前节点，在左子树中递归
        // 如果当前节点>当前节点在右子树中递归，
        //知道当前节点为空，停止递归

        Node p = tree;
        while (p != null) {
            if (data < p.data) p = p.left;
            else if (data > p.data) p = p.right;
            else return p;
        }
        return null;
    }


    /**
     * 插入
     * @param data
     */
    public void insert(int data) {
        // 如果根节点为空，value放到根节点上
        // 如果value < 根节点，并且左子树为空，直接放到左子树上
        // 如果value < 根节点，并且左子树不为空，递归左子树，找到空的位置放上value
        // 如果value > 根节点，并且右子树为空，直接放到右子树上
        // 如果value < 根节点，并且右子树不为空，递归右子树，找到空的位置放上value
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (true) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }


    /**
     * 删除
     * @param data
     */
    public void delete(int data) {
        Node p = tree; //
        Node pp = null; // pp 记录的是p的父节点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) p = p.right;
            else p = p.left;
        }
        if (p == null) return; // 没找到

        // 要删除的节点有两个节点
        if (p.left != null && p.right != null) { // 查找右边子树的最小节点
            Node minP = p.right;
            Node minPP = p; // minPP 是minP 的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data; // 将minP 的数据替换到p中。
            p = minP; // 下面就变成了删除minP.
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有1个子节点。
        Node child; // p 的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) tree = child; //删除的是根节点
        else if(pp.left == p) pp.left = child;
        else pp.right = child;
    }


    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

//    /**
//     * 前序遍历伪代码
//     * @param root
//     */
//    void preOrder(Node root) {
//        if (root == null) return;
//        print root;
//        preOrder(root.left);
//        preOrder(root.right);
//    }

//    /**
//     * 中序遍历伪代码
//     * @param root
//     */
//    void preOrder(Node root) {
//        if (root == null) return;
//        preOrder(root.left);
//        print root;
//        preOrder(root.right);
//    }
//
//    /**
//     * 后序遍历伪代码
//     * @param root
//     */
//    void preOrder(Node root) {
//        if (root == null) return;
//        preOrder(root.left);
//        preOrder(root.right);
//        print root;
//    }

}
