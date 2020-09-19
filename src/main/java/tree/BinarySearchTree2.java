package tree;


/**
 * 二叉查找树
 */
public class BinarySearchTree2 {

    private TreeNode tree;

    /**
     * 查找一个值
     * @param data
     * @return
     */
    public TreeNode find(int data) {
        TreeNode p = tree;
        while (p != null) {
            if (p.getData() == data) {
                return p;
            } else if(p.getData() > data) {
                p = p.getLeft();
            }else {
                p = p.getRight();
            }
        }
        return null;
    }

    /**
     * 插入一个不重复元素。
     * @param data
     */
    public void insert(int data) {
        TreeNode p = tree;
        if (p == null) {
            tree = new TreeNode();
            tree.setData(data);
            return;
        }
        while (true) {
            if (p.getData() > data) {
                if (p.getLeft() == null) {
                    TreeNode node = new TreeNode();
                    node.setData(data);
                    p.setLeft(node);
                    return;
                }else {
                    p = p.getLeft();
                }
            }else if (p.getData() < data) {
                if (p.getRight() == null) {
                    TreeNode node = new TreeNode();
                    node.setData(data);
                    p.setRight(node);
                    return;
                }else {
                    p = p.getRight();
                }
            }
        }
    }

    /**
     * 删除一个元素。
     * @param data
     */
    public void delete(int data) {
        TreeNode p = tree;
        TreeNode pp = null; // pp 是 p的父节点。
        while (p != null && p.getData() != data) {
            pp = p;
            if (p.getData() > data) {
                p = p.getLeft();
            }else {
                p = p.getRight();
            }

        }
        if (p == null) return;

        //要删除的节点有两个节点
        if (p.getLeft() != null && p.getRight() != null) {
            TreeNode minP = p.getRight();
            TreeNode minPP = p;
            while (minP.getLeft() != null) {
                minPP = minP;
                minP = minP.getLeft();
            }
            p.setData(minP.getData());
            p = minP;
            pp = minPP;
        }

        //要删除的节点是叶子节点 或者仅仅有一个节点
        if (p.getLeft() != null) {
            pp = p.getLeft();
            return;
        }else if (p.getRight() != null) {
            pp = p.getRight();
            return;
        }else {
            pp = null;
            return;
        }
    }

}
