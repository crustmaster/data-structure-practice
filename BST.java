
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

    /* search in a BST, and return a bst with the expected value as the root. */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) { return null; }
        if (root.val == val) { return root; }
        if (val < root.val) { return searchBST(root.left ,val); }
        return searchBST(root.right, val);
    }

    /* insert an item in a BST, and return the new BST. (recursion) */
    public TreeNode insertIntoBST_method1(TreeNode root, int val) {
        if (root == null) { return new TreeNode(val); }
        if (root.val < val) { root.right = insertIntoBST(root.right, val); }
        if (root.val > val) { root.left = insertIntoBST(root.left, val); }
        return root;
    }
    
    /* insert an item in a BST, and return the new BST. (Iteration) */
    public TreeNode insertIntoBST_method2(TreeNode root, int val) {
        if (root == null) { return new TreeNode(val); }
        TreeNode parent = root;
        TreeNode p = root;
        while( root != null ) {
            p = root;
            if (root.val == val) { return parent; }
            else if (root.val > val) { root = root.left; }
            else { root = root.right; }
        }
        if (p.val > val) { p.left = new TreeNode(val); }
        else { p.right = new TreeNode(val); }
        return parent;
    }

    








    

}

/*
leetcode
#98 验证搜索二叉树    https://leetcode.cn/problems/validate-binary-search-tree/description/
#173 二叉搜索树迭代器    https://leetcode.cn/problems/binary-search-tree-iterator/description/
#700 二叉搜索树中的搜索    https://leetcode.cn/problems/search-in-a-binary-search-tree/description/
#701 二叉搜索树中的插入操作    https://leetcode.cn/problems/insert-into-a-binary-search-tree/description/
*/
