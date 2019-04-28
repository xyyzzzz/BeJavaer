package datastructure.binarytree;

/**
 * @author CNan
 */
public class BinaryTree {
    /**
     * 求二叉树的最大深度
     */
    int maxDeath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDeath(node.left);
        int right = maxDeath(node.right);
        return Math.max(left, right) + 1;
    }


    /**
     * 求二叉树的最小深度
     */
    int getMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }


    int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }

    /**
     * 求二叉树中节点的个数
     */
    int numOfTreeNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = numOfTreeNode(root.left);
        int right = numOfTreeNode(root.right);
        return left + right + 1;
    }

//    /**
//     * 求二叉树中叶子节点的个数
//     * */
//    int numsOfNoChildNode(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        if (root.left == null && root.right == null) {
//            return 1;
//        }
//        return numsOfNodeTreeNode(root.left) + numsOfNodeTreeNode(root.right);
//    }
}
