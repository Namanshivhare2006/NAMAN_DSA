class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = check(root.left, p, q);
        TreeNode right = check(root.right, p, q);

        if (left != null && right != null) return root;

        return (left != null) ? left : right;
    }

    static TreeNode check(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = check(root.left, p, q);
        TreeNode right = check(root.right, p, q);

        if (left != null && right != null) return root;

        return (left != null) ? left : right;
    }
}