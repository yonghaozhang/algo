package tree;

public class BinarySearchTreeLearning {


    BinarySearchTree.Node find(BinarySearchTree.Node tree, int value) {
        if (tree == null) return null;
        BinarySearchTree.Node p = tree;
        while (p!=null) {
            if (p.data == value) return p;
            if (value < p.data) {
                p = p.left;
            }else {
                p = p.right;
            }
        }
        return null;
    }

    void insert(BinarySearchTree.Node tree, int value) {
        // 如果根节点为空，value放到根节点上
        if (tree ==null) {
            tree = new Node(value);
        }

        Node p = tree;
        while (true) {
            if (value < p) {
                if (p.left == null) {
                    p.left = new Node(value);
                    return;
                }
                p = p.left;
                if (value > p) {
                    if (p.right == null) {
                        p.right = new Node(value);
                        return;
                    }
                    p = p.right;
                }
            }
        }
    }

}
