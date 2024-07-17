
public class BST {

    /* make definition of BST*/
    TreeNode root;
    public BST() { root = null; }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(val) { this.val = val; }
    }

    /* testify the root is a valid BST or not. (eg: in case the left_value may bigger than root_value.)*/
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBSTHelper (TreeNode root, long min, long max) {
        if (root == null) { return true; }
        if (root.val <= min || root.val >= max ) { return false; }
        if ( !isValidBSTHelper (root.left, min, root.val) ) { return false; }
        if ( !isValidBSTHelper (root.right, root.val, max) ) { return false; }
        return true;
    }

}
